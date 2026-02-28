import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class tema2A {

    WebDriver driver;

    /*
    Deschide un site -> deschide browser, navigheaza catre un URL (la alegere), inchide browserul
     */
    @Test
    public void loadPage() {
        driver = new ChromeDriver();
        driver.get("https://www.artstation.com/?sort_by=community&dimension=all");

        driver.close();
    }

    /*
    Verifica titlul paginii -> deschide URL-ul (la alegere, sau https://example.com/)
    ia titlul paginii, verifica cu Assert titlul
    getTitle(), Assert.assertTrue
     */
    @Test
    public void checkTitle() {
        driver = new ChromeDriver();
        driver.get("https://example.com/");

        System.out.println(driver.getTitle());
        String actualT = driver.getTitle();
        String expectedT = "Example Domain";

        Assert.assertEquals(actualT, expectedT, "Validate page title");

        driver.quit();
    }
}

