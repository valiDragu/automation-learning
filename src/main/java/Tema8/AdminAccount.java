package Tema8;

public class AdminAccount extends Account{
    private String role;

    public AdminAccount(String username, String role) {
        super(username);
        this.role = role;
    }

    public void deleteUser() {
        System.out.println("User " + role + " deleted");
    }
}
