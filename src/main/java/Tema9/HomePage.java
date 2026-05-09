package Tema9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    List <WebElement> productList;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void openApp() {
        driver.get("https://practicesoftwaretesting.com/");
    }

    public void clickOnProduct(String productName) {
        List<WebElement> productList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h5[@data-test='product-name']")));

        for (WebElement product : productList) {
            if (product.getText().trim().equals(productName)) {
                product.click();
                break;
            }
        }
    }

}
