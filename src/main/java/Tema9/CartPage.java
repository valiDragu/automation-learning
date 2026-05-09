package Tema9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By cartItems = By.xpath("//div[@class='ng-star-inserted']/table");
    By cartProduct = By.xpath("//span[@class='product-title']");
    By cartPrice = By.xpath("//span[@data-test='product-price']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public String getCartProductName() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(cartProduct)).getText().trim();
    }

    public String getCartProductPrice() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(cartPrice)).getText().trim().substring(1);
    }

    public void isProductInCart(String productName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(cartItems));
        String cartProductName = wait.until(ExpectedConditions.presenceOfElementLocated(cartProduct)).getText().trim();
        Assert.assertEquals(cartProductName, productName, "Product " + productName + " not found in cart");
    }
}
