package tema3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tema3B {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver  =  new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tabel() {
        driver.get("https://demoqa.com/webtables");

        WebElement add = driver.findElement(By.id("addNewRecordButton"));
        add.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("test");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("TEST");

        WebElement email =  driver.findElement(By.id("userEmail"));
        email.sendKeys("test@example.com");

        WebElement age  = driver.findElement(By.id("age"));
        age.sendKeys("123");

        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("12345");

        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("test");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

}
