package Tema8;

public class Account {
    private String username;

    public Account(String username) {
        this.username = username;
    }

    public void login() {
        System.out.println(username +" logged in");
    }
}
