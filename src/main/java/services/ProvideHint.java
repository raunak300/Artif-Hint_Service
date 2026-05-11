package services;

import com.rbm.artif.hint.dto.InputDTO;
import com.rbm.artif.hint.utilites.Premium;

public interface ProvideHint {
	public boolean checkHintCount(String email, Premium role);
	
	public void closeSession();

	boolean checkValidSesssion(String email);

	public String createSession(String email);

	public String provideHint(InputDTO dto);
}
