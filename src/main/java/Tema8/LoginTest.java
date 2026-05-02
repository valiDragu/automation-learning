package Tema8;

public class LoginTest extends TestCase {

    public LoginTest(String name) {
        this.name = name;
    }

    @Override
    public void runTest() {
        System.out.println("User: " + name + " logged in.");
    }
}
