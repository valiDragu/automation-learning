import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGoogle2 {
    WebDriver driver;

    @BeforeClass
    public void setup () {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void searchTest(){
        driver.findElement(By.xpath("//*[text()='Acceptă tot']")).click();

        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).submit();
    }

    @Test
    public void searchWiki(){
        driver.navigate().back();

        driver.findElement(By.name("q")).sendKeys("Wikipedia");
        driver.findElement(By.name("q")).submit();
    }
}
