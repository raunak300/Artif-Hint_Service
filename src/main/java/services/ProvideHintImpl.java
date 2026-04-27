package services;

import com.rbm.artif.hint.dto.QuestionDTO;

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
    public String provideHint(QuestionDTO questionDTO) {

        if(!checkHintCount(questionDTO.getUser().getEmail()) ){
            return "";

        }

        if(!checkValidSesssion(questionDTO.getUser().getEmail())){

            return "";
        }


        return "";
    }
}
