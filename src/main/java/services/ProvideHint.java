package services;

import com.rbm.artif.hint.dto.InputDTO;

public interface ProvideHint {
	public boolean checkHintCount(String email);
	
	public void closeSession();

	boolean checkValidSesssion(String email);

	public String createSession(String email);

	public String provideHint(InputDTO dto);
}
