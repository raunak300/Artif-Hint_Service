package services;

public class ProvideHintImpl implements ProvideHint{

    @Override
    public boolean checkHintCount(String email) {

        return false;
    }

    @Override
    public void closeSession() {

    }

    @Override
    public String createSession(String email) {
        return "";
    }
}
