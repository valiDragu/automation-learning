import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Refactorizeaza clasa de la exercitiul 3 sa foloseasca @BeforeMethod si @AfterMethod
 */
public class tema2C {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void site1() {
        driver.get("https://example.com/");
    }

    @Test
    public void site2() {
        driver.get("https://www.apple.com/");
    }
}
