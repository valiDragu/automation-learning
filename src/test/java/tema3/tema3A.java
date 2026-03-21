package tema3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class tema3A {

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


//    Creaza un test, pornind de la URL-ul: https://demoqa.com/automation-practice-form
    @Test
    public void practiceForm() {

        driver.get("https://demoqa.com/automation-practice-form");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        Gaseste campul First Name folosind Xpath, bazat pe placeholder
//        Introdu in acel camp valoarea “Test”
        WebElement firstName = driver.findElement(By.xpath("//input[contains(@placeholder, 'First Name')]"));
        firstName.sendKeys("Test");

//        Gaseste campul Last Name folosing XPath bazat pe atributul id
//        Introdu valoarea “User”
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        lastName.sendKeys("User");

//        Gaseste campul Email folosing XPath bazat pe atributul id
//        Introdu textul “test@email.com”
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("test@email.com");

//        Apasa oricare din butoanele radio de la Gender
        WebElement radio = driver.findElement(By.xpath("//input[@value='Male']"));
        radio.click();

//        Introdu un numar de telefon in campul pentru Mobile
        WebElement phone = driver.findElement(By.xpath("//input[contains(@placeholder, 'Mobile')]"));
        phone.sendKeys("01234567890");

//        Introdu un text in campul pentru ‘Subjects’
        WebElement subjects = driver.findElement(By.xpath("//input[@id ='subjectsInput']"));
        subjects.click();
        subjects.sendKeys("m");

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, '-option') and text()='Maths']")
        ));
        option.click();


//        Introdu un text in campul pentru ‘Current Address’
        WebElement address = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("testAddress");

//        Gaseste butonul Submit dupa text si apasa folosind click
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        Actions action = new Actions(driver);
        action.scrollToElement(submit);
        submit.click();

        WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='closeLargeModal']")));
        close.click();
    }
}
