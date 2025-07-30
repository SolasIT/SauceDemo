package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Проверка авторизации")
    @Description("Проверка авторизации")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("Login in saucedemo")
    @Story("Авторизация")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-7")
    public void checkLoginPositive() {
        loginPage.open()
                .login(user, password);
        softAssert.assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(testName = "Проверка авторизации без заполнения всех полей")
    @Description("Проверка авторизации без заполнения всех полей")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("Login in saucedemo")
    @Story("Авторизация")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-8")
    public void checkLoginWithEmptyFields() {
        loginPage.open()
                .login("", "");
        softAssert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
    }

    @Test(testName = "Проверка авторизации без заполнения пароля")
    @Description("Проверка авторизации без заполнения пароля")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("Login in saucedemo")
    @Story("Авторизация")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-9")
    public void checkLoginWithEmptyPassword() {
        loginPage.open()
                .login(user, "");
        softAssert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось");
    }

    @Test(testName = "Проверка авторизации без заполнения имени")
    @Description("Проверка авторизации без заполнения имени")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("Login in saucedemo")
    @Story("Авторизация")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-10")
    public void checkLoginWithEmptyUserName() {
        loginPage.open()
                .login("", password);
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "LoginData", testName = "Негативные тесты")
    @Description("Проверка авторизации: используя {0} и {1}")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("Login in saucedemo")
    @Story("Авторизация")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-10")
    public void checkLoginWithNegativeValue1(String user, String password, String expectedMessage) {
        loginPage.open()
                .login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует");
    }
}