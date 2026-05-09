package Tema9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    By searchBox = By.xpath("//input[@data-test='search-query']");
    By searchBtn = By.xpath("//button[@data-test='search-submit']");
    By searchTerm = By.xpath("//span[@data-test='search-term']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement() {
        driver.findElement(searchBox).click();
    }

    public void addText(String searchParam) {
        driver.findElement(searchBox).sendKeys(searchParam);
        driver.findElement(searchBtn).click();
    }

    public String getText() {
        return driver.findElement(searchTerm).getText();
    }

}
