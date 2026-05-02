package Tema8;

public class LoginService extends  User{

    public LoginService(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void login() {
        System.out.println("User " + username  + " logged in.");
    }
}
