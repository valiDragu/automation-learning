package tema2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
Creaza o clasa care are doua teste:
unul care navigheaza la https://example.com/ si inchide browserul;
unul care navigheaza la https://www.apple.com/ si inchide browserul.
 */
public class tema2B {

    WebDriver driver;

    @Test
    public void site1() {
        driver = new ChromeDriver();
        driver.get("https://example.com/");

        driver.close();
    }

    @Test
    public void site2() {
        driver = new ChromeDriver();
        driver.get("https://www.apple.com/");

        driver.close();
    }

}
