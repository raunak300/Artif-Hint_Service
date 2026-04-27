package services;

import com.rbm.artif.hint.dto.InputDTO;

public class ProvideHintImpl implements ProvideHint{

    @Override
    public boolean checkHintCount(String email) {
        // call redis and remove from redis
        return false;
    }

    @Override
    public void closeSession() {

    }

    @Override
    public boolean checkValidSesssion(String email){
        //check in mdb session if it is correct or not
        return true;
    }

    @Override
    public String createSession(String email) {

        return "";
    }

    @Override
    public String provideHint(InputDTO inputDTO) {

        if(!checkHintCount(inputDTO.getUser().getEmail()) ){
            return "";

        }
        if(!checkValidSesssion(inputDTO.getUser().getEmail())){

            return "";
        }

        //call AI_Agent


        return "";
    }
}
