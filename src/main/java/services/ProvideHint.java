package services;

public interface ProvideHint {
	public boolean checkHintCount(String email);
	
	public void closeSession();
	
	public String createSession(String email);
}
