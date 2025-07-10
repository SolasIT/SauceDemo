package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(priority = 2, testName = "Позитивный тест авторизации")
    public void checkLoginPositive() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(priority = 3,
            testName = "Авторизация с пустыми полями", timeOut = 15000)
    public void checkLoginWithEmptyFields() {
        loginPage.open();
        loginPage.login("", "");
        softAssert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
    }

    @Test(priority = 4, invocationCount = 2, testName = "Негативный тест логина без пароля", groups = {"smoke"})
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        softAssert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось");
    }

    @Test(priority = 1, testName = "Негативный тест логина без логина")
    public void checkLoginWithEmptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
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

    @Test(dataProvider = "LoginData", groups = {"smoke"}, testName = "Негативный тест логина")
    public void checkLoginWithNegativeValue1(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует");
    }
}