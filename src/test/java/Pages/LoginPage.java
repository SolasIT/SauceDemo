package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By userField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы сайта")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Авторизация")
    public void login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Получение ошибки")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}