public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
//çalıştırıyom
        userManager.register("Sena", "Kara", "senakara@douloop.com", "123456"); // success
        userManager.register("Beyza", "Gürel", "gbeyza@douloop.com", "12345");
        userManager.register("Sena","kara", "senakara@douloop.com","123456");
        userManager.login("senakara@douloop.com","123456");
  }}