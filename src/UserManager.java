import java.util.ArrayList;
import java.util.List;
public class UserManager {
    private List<User> users = new ArrayList<>();//users aında kullanıcı listesi oluşturdum.Kaydedilen tüm kullanıcıları burda tutuyor doğrulamama yardumcu oluyor.
    private EmailValidator emailValidator = new EmailValidator();
    private PasswordValidator passwordValidator = new PasswordValidator();
    
    
    //bir kullanıcının e-posta adresine göre kullanıcı bilgilerini döndürür
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
    
//Kaydetme fonksiyonu oluşturdum.isim soyisim email ve şifre ile olunuyor.Verilen şartları sağlamadığı zaman hata mesajı veriyor
    public boolean register(String firstName, String lastName, String email, String password) {
        if (!emailValidator.validate(email)) {//emailin şart kontrollerini sağlıyor.
            System.out.println("Email format is incorrect.");
            return false;
        }

        if (!passwordValidator.validate(password)) {//şifrenin şart koşullarını kontrol eden nesneyi kullanıyoz
            System.out.println("Password is too weak. It should be at least 6 characters long.");
            return false;
        }

        if (getUserByEmail(email) != null) { //getUserByEmail metodu ile mail var mı yok mu kontrol eder
            System.out.println("A user with this email already exists.");
            return false;
        }

        if (firstName.length() < 2 || lastName.length() < 2) { ///burda verilen ad ve soad şartlarının kontrolü sağlanıyor
            System.out.println("First name and last name should be at least 2 characters long.");
            return false;
        }
//"firstName", "lastName", "email" ve "password" parametreleri kullanarak yeni bir kullanıcı oluşturur.Sonra bu kullanıcı nesnesi "users" listesine ekler ve kayıt mesajı yazar.
        
        User user = new User(firstName, lastName, email, password);
        users.add(user);

        System.out.println("User registered successfully. Verification email has been sent.");
        return true;
    }
//e-posta adresi ve bir şifre alır ve e-posta ve şifre doğruysa kullanıcıyı döndürür.
    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return user;
            }
        }

        System.out.println("Login failed. Please check your email and password.");
        return null;
    }

  //Burda da mail gönderir.

    public void sendVerificationEmail(User user) {
        System.out.println("Verification email sent to " + user.getEmail());
    }
}
