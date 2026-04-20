package Tema8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    protected WebDriver driver;

    public void setDriver() {
        this.driver = new ChromeDriver();
    }

    public void openUrl(String url) {
        driver.get(url);
    }
}
