package Tema9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    By productName = By.xpath("//h1[@data-test='product-name']");
    By productPrice = By.xpath("//span[@data-test='unit-price']");
    By addToCart = By.xpath("//button[@data-test='add-to-cart']");
    By goToCart = By.xpath("//a[@data-test='nav-cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(productName)).getText().trim();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(productPrice)).getText().trim();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCart)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToCart)).click();
    }

}
