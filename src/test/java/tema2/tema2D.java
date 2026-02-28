package tema2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tema2D {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://example.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checkTitle() {
        System.out.println(driver.getTitle());
        String actualT = driver.getTitle();
        String expectedT = "Example";

        Assert.assertNotNull(driver.getTitle(), "Verify the title is not null");
        Assert.assertTrue(actualT.contains(expectedT), "Verify title contains 'Example'");
    }
}
