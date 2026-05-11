package services;

import com.rbm.artif.hint.Entity.Hints;
import com.rbm.artif.hint.Entity.Session;
import com.rbm.artif.hint.dto.InputDTO;
import com.rbm.artif.hint.repository.hintsDB;
import com.rbm.artif.hint.repository.sessionDB;
import com.rbm.artif.hint.utilites.Premium;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class ProvideHintImpl implements ProvideHint{



    @Autowired
    private sessionDB sessionDB;



    @Autowired
    private hintsDB hintsDB;

    public static String generateUUID() {
        return UUID.randomUUID().toString();
        // in case "-" is not required then=> UUID.randomUUID().toString().replace("-","")
    }

    @Override
    //updation requires Redis
    public boolean checkHintCount(String email, Premium premium) {
        try {
            Hints hint=hintsDB.findById(email).orElse(null);

            //Getting LocalDate using UTC
            LocalDate todayUTC = LocalDate.now(ZoneId.of("UTC"));
            LocalDateTime endTime = LocalDateTime.of(todayUTC, LocalTime.MAX);
            //assuming using UTC for Time in DB for any user at any timeZone
            Date closesAt = Date.from(
                    endTime.atZone(ZoneId.of("UTC")).toInstant()
            );

            if(hint==null){

                hint=new Hints();
                hint.setEmail(email);
                hint.setPremium(premium);
                hint.setUsage( Premium.FREE.equals(premium)? 2 : Premium.PREMIUM.equals(premium) ? 9 : 499 );
                //expires at night 11:59:59
                hint.setClosesAt(closesAt);

                hintsDB.save(hint);
                return true;

            }

            if(hint.getUsage()==0){
                //hints finished for user and can't be made any further
                return false;
            }

            //need is to update the DB with current callsnumber or reduce call count by 1
            hint.setUsage(hint.getUsage()-1);
            hintsDB.save(hint);
            //this above statement does not create a new collection instead it updates the DB with new feild
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Boolean closeSession(String email) {
        //delete session from mdb
        try {
            //sessionDB.deleteBySessionId(sessionId);
            sessionDB.deleteById(email); // this one will do things faster
        }catch(Exception e){
            throw new RuntimeException("Error in closing Session");
        }
        return true;
    }

    @Override
    public boolean checkValidSesssion(String email){
        //check in mdb session if it is correct or not
        Session existingSession= new Session();

        try{
            existingSession = sessionDB.findById(email).orElse(null);
            if(existingSession==null || existingSession.isActive()==false){
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public String createSession(String email) {
        Session savedUser=new Session();
        try{
            String sessionId=generateUUID();
            savedUser.setSessionId(sessionId);
            savedUser.setEmail(email);
            savedUser.setActive(true);
            sessionDB.save(savedUser);
        } catch (Exception e) {
            String message="Error in Creating Session";
            throw new RuntimeException(message);
        }
        return savedUser.getSessionId();

    }

    @Override
    public String provideHint(InputDTO inputDTO) {

        //hint count check
        try {
            if(!checkHintCount(inputDTO.getUser().getEmail(),inputDTO.getUser().getPremium()) ){
                throw new RuntimeException("Hint Limit Reached");

            }
            //if hint exist then check if session exist-> if not then make one
            if(inputDTO.getSessionId()==null || inputDTO.getSessionId().isEmpty()){
                createSession(inputDTO.getUser().getEmail());
            }
            //checking if session is active or not in DB
            if(!checkValidSesssion(inputDTO.getUser().getEmail())){
                throw new RuntimeException("Session Not Valid");
            }

            //call AI_Agent --> will do it not a thing to do now
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }



        return "";
    }
}
