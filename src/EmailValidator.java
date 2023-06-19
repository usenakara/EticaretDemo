
public class EmailValidator {
	//regex yapısı ile e-mail de istediğimiz şartları kontrol ederiz
	
	    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@douloop\\.com$";

	    public boolean validate(String email) {
	        return email.matches(EMAIL_REGEX);
	    }
	}


