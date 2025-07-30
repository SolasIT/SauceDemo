package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductInCartTest extends BaseTest {

    @Test(testName = "Проверка добавления товара в корзину с главной страницы",
            description = "Проверка добавления товара в корзину с главной страницы")
    @Description("Проверка добавления товара в корзину с главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("add to cart in saucedemo")
    @Story("Добавление в корзину")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-4")
    public void checkAddProductInCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open()
                        .login(user, password);
        productsPage.addToCart("BackPack")
                        .openCart();
        softAssert.assertEquals(
                cartPage.getTitle(),
                "Your Cart",
                "Не удалось перейти в корзину");
        softAssert.assertEquals(
                cartPage.getItemBackPack(),
                "Sauce Labs Backpack",
                "Не удалось добавить рюкзак в корзину");
        softAssert.assertAll();
    }
}