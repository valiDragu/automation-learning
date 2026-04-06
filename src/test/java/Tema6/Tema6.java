package Tema6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tema6 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }


    /*
    Creează un test care:
        deschide un site
        deschide un tab nou (WindowType.TAB)
        accesează alt site în noul tab
        Afișează titlul ambelor taburi
     */
    @Test(priority = 2, groups = {"smoke"})
    public void test1() {
        driver.get("https://www.selenium.dev/");
        String firstTab = driver.getTitle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://testng.org/");
        String secondTab = driver.getTitle();

        System.out.println(firstTab);
        System.out.println(secondTab);
    }


    /*
    Creează un test care:
        deschide 2 taburi
        salvează windowHandles
        navighează între ele
        Verifică titlul fiecărui tab folosind Assert
     */
    @Test(priority = 1, groups = {"sanity"})
    public void test2() {
        driver.navigate().to("https://www.selenium.dev/");
        String firstTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get("https://testng.org/");
        String secondTab = driver.getWindowHandle();

        Assert.assertEquals(driver.switchTo().window(firstTab).getTitle(), "Selenium", "Not Selenium documentation tab");

        Assert.assertEquals(driver.switchTo().window(secondTab).getTitle(), "TestNG Documentation", "Not TestNG documentation tab");
    }


    /*
    Creează un test care:
        deschide 2 taburi
        închide unul cu driver.close()
        revine pe tabul principal
        Verifică dacă încă ești pe pagina corectă
        Ruleaza testul folosing fisier .xml
     */
    @Test(groups = {"ex3", "functional"}, priority = 0)
    public void test3() {
        driver.navigate().to("https://www.selenium.dev/");
        String firstTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get("https://testng.org/");
        driver.close();

        driver.switchTo().window(firstTab);
        Assert.assertEquals(driver.getWindowHandle(), firstTab);
    }


    /*
     Creează un test care:
        Deschide https://practicesoftwaretesting.com/
        Navighează pe o categorie
        Deschide produsul într-un tab nou
        Revine în tabul principal
        Face refresh
        Adauga:
            @BeforeMethod
            @AfterMethod
            Assert
        Ruleaza testul folosind un fisier .xml
     */
    @Test(groups = {"ex4", "functional"}, priority = -1)
    public void test4() {
        driver.get("https://practicesoftwaretesting.com/");
        String firstTab = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Hand Saw')]/input"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='filter_completed']")));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND).click(driver.findElement(By.xpath("//a[@class='card'][1]"))).keyUp(Keys.COMMAND).perform();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!firstTab.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("product"), "This is not the product details tab");

        driver.switchTo().window(firstTab);
        driver.navigate().refresh();
        Assert.assertTrue(!(driver.getCurrentUrl().contains("product")), "This is not the main tab");


    }
}
