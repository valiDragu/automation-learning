package tema5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class tema5 {

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
    Folosind pagina https://practicesoftwaretesting.com/
        Accesează o categorie de produse.
        Folosește filtrele disponibile.
        Selectează un filtru (ex: brand).
        Verifică faptul că cel puțin două produse conțin numele categoriei selectate.
     */
    @Test
    public void filterCategories() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement other = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[14]")));
        if(!other.isSelected()) {
            other.click();
        }

        WebElement eco = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[22]")));
        if(!eco.isSelected()) {
            eco.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='filter_completed']")));
        List <WebElement> searchResults = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='card']")));
        List <WebElement> ecoTags = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@data-test='eco-badge']")));

        int numberOfResults = searchResults.size();
        int numberOfEcoTags = ecoTags.size();

        Assert.assertEquals(numberOfEcoTags, numberOfResults, "Filter mismatch for one ore more items.");

        System.out.println("All " + numberOfResults + " search results have an eco tag");
    }


    /*
    Folosind pagina https://practicesoftwaretesting.com/
        Deschide un produs.
        Apasă Add to cart.
        Deschide coșul.
        Verificare:
            produsul apare în coș
            cantitatea este 1.
     */
    @Test
    public void checkThatProductIsAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='card'])[5]")));
        product.click();

        String productName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test='product-name']"))).getText();
        String productQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test='quantity']"))).getAttribute("value");
        String trimmedName = productName.trim();

        WebElement addToCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test='add-to-cart']")));
        addToCard.click();

        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='lblCartCount']")));
        cartIcon.click();

        String cartItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='product-title']"))).getText();
        String cartQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='product-quantity']"))).getAttribute("value");
        String trimmedCartName = cartItemName.trim();

        Assert.assertEquals(trimmedCartName, trimmedName, "Incorrect product in cart");
        Assert.assertEquals(cartQuantity, productQuantity, "Incorrect quantity in cart");
    }


    /*
    Test Case:
        Accesează site-ul.
        Caută produsul Hammer.
        Deschide produsul.
        Adaugă produsul în coș.
        Deschide coșul.
        Verifică:
            produsul este în coș
            cantitatea este 1
            prețul este afișat.
     */
    @Test
    public void checkProductQuantityAndPriceInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='card'])[1]")));
        product.click();

        String productName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test='product-name']"))).getText();
        String productQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test='quantity']"))).getAttribute("value");
        String productPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test='unit-price']"))).getText();
        String trimmedName = productName.trim();

        WebElement addToCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test='add-to-cart']")));
        addToCard.click();

        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='lblCartCount']")));
        cartIcon.click();

        String cartItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='product-title']"))).getText();
        String cartQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='product-quantity']"))).getAttribute("value");
        String cartPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='product-price']"))).getText();
        String trimmedCartName = cartItemName.trim();
        String trimmedCartPrice = cartPrice.replace("$", "");

        Assert.assertEquals(trimmedCartName, trimmedName, "Incorrect product in cart");
        Assert.assertEquals(cartQuantity, productQuantity, "Incorrect quantity in cart");
        Assert.assertEquals(productPrice,trimmedCartPrice, "Incorrect price in cart");
    }

}
