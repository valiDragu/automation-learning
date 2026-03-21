package tema4;

import io.opentelemetry.sdk.metrics.internal.data.EmptyExponentialHistogramBuckets;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.beans.Visibility;
import java.time.Duration;
import java.util.List;

public class tema4 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }


    /*
    Creează un test care:
        Deschide aplicația https://practicesoftwaretesting.com/ .
        Verifică titlul paginii.
        Verifică dacă logo-ul aplicației este vizibil.
     */
    @Test
    public void checkTitleAndLogo() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Practice Software Testing - Toolshop - v5.0", "Title is incorrect");

        WebElement logo = driver.findElement(By.xpath("//*[@id='Layer_1']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is missing");
    }


    /*
    Creează un test pentru căutarea unui produs
        Identifică search bar.
        Introdu textu “hammer”
        Apasă Enter sau butonul de căutare.
        Așteaptă afișarea rezultatelor.
        Verifică dacă apare cel puțin un produs în listă.
     */
    @Test
    public void searchProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='search-query']")));
        searchBar.clear();
        searchBar.sendKeys("Hammer" + Keys.ENTER);

        // wait for the search to finish
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='search_completed']")));
        // wait for the search results to load
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("card")));
        // then store all search results into a list
        List <WebElement> hammers = driver.findElements(By.className("card"));

        // check that the search returned at least 1 result
        Assert.assertFalse(hammers.isEmpty(), "Expected at least 1 search result to be returned");
        // check that each search result matches the search parameter
        for (int i = 0; i < hammers.size(); i++) {
            String resultName = hammers.get(i).getText();
            Assert.assertTrue(resultName.contains("ammer"), "Item number " + (i + 1) + " is not a hammer. Found: " + resultName);
        }

    }


    /*
    Creează un test pentru deschiderea unui produs
        Deschide pagina principală.
        Așteaptă încărcarea produselor.
        Apasă pe primul produs din listă.
        Verifică dacă:
            imaginea produsului este vizibilă
            butonul Add to cart este vizibil.
     */
    @Test
    public void productDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstListedProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='card'])[1]")));
        firstListedProduct.click();

        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='card-img-wrapper']")));
        WebElement addToCardBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='add-to-cart']")));

        Assert.assertTrue(productImage.isDisplayed(), "Missing product image");
        Assert.assertTrue(addToCardBtn.isDisplayed(), "Add to cart button is not displayed");
    }


    /*
    Creează un test pentru filtrarea produselor
        Deschide pagina principală.
        Selectează un filtru (ex: brand sau categorie)
        Așteaptă actualizarea listei.
        Verifică dacă produsele afișate respectă filtrul.
     */
    @Test
    public void chiselFilter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement chisels = driver.findElement(By.xpath("(//*[@type='checkbox'])[7]"));

        if (!chisels.isSelected()) {
            chisels.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='filter_completed']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card")));
        List<WebElement> filterResults = driver.findElements(By.className("card"));

        Assert.assertFalse(filterResults.isEmpty(), "No products listed when using the filter");
        for (int i = 0; i < filterResults.size(); i++) {
            String filteredProductTitle = filterResults.get(i).getText();
            Assert.assertTrue(filteredProductTitle.contains("Chisels"), "Item " + (i+1) + " is not a chisel.");
        }
    }
}
