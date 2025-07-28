package Pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final String BASE_URL = "https://www.saucedemo.com";

    static WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract BasePage open();

    public abstract BasePage isPageOpened();
}
