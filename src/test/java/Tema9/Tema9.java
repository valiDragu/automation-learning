package Tema9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tema9 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Test1() {
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.openApp();
        String productName = "Pliers";
        homePage.clickOnProduct(productName);

        String productPageName = productPage.getProductName();
        String productPagePrice = productPage.getProductPrice();
        productPage.addToCart();
        productPage.goToCart();

        String cartPageName = cartPage.getCartProductName();
        String cartPagePrice = cartPage.getCartProductPrice();
        cartPage.isProductInCart(productName);

        Assert.assertEquals(productPageName, cartPageName, "Incorrect product name in cart");
        Assert.assertEquals(productPagePrice, cartPagePrice, "Incorrect product price in cart");
    }

    @Test
    public void Test2() {
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.openApp();
        String productName = "Bolt Cutters";
        homePage.clickOnProduct(productName);

        String productPageName = productPage.getProductName();
        String productPagePrice = productPage.getProductPrice();

        Assert.assertNotNull(productPageName, "Missing Product name");
        Assert.assertTrue(0 < Double.parseDouble(productPagePrice), "Product's price is 0");

    }

}
