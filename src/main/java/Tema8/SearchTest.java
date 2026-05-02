package Tema8;

public class SearchTest extends TestCase {

    public SearchTest(String name) {
        this.name = name;
    }

    @Override
    public void runTest() {
        System.out.println("Searched for: " + name);
    }
}
