package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final String BASE_URL = "https://www.saucedemo.com";

    static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
