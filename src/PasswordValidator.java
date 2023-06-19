
public class PasswordValidator {
	//şifrenin uzunluğunu kontrol ediyoz.Aslında email ile password validatorlerini UserValidator ile yapabiliriz ama böyle de oluyo :)
	    public boolean validate(String password) {
	        return password.length() >= 6;
	    }
}


