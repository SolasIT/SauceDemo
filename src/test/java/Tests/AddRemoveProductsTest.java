package Tests;

import Pages.CartPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddRemoveProductsTest extends BaseTest {

    @Test(testName = "Проверка удаления товара из корзины",
            description = "Проверка добавления и удаления товара")
    @Description("Проверка удаления товара из корзины")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("add to cart in saucedemo")
    @Story("Удаление из корзины")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-6")public void addRemoveProducts() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open()
                        .login(user, password);
        productsPage.addToCart("Sauce Labs Backpack")
                .addToCart("Sauce Labs Bike Light")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .addToCart("Sauce Labs Fleece Jacket")
                .openCart();
        softAssert.assertEquals(
                cartPage.getTitle(),
                "Your Cart",
                "Не удалось перейти в корзину");
        softAssert.assertTrue(CartPage.isProductInCart("Sauce Labs Backpack"),
                "Не удалось добавить рюкзак в корзину");
        softAssert.assertTrue(CartPage.isProductInCart("Sauce Labs Bike Light"),
                "Не удалось добавить велосипед в корзину");
        softAssert.assertTrue(CartPage.isProductInCart("Sauce Labs Bolt T-Shirt"),
                "Не удалось добавить футболку в корзину");
        softAssert.assertTrue(CartPage.isProductInCart("Sauce Labs Fleece Jacket"),
                "Не удалось добавить флисовый свитер в корзину");

        cartPage.getRemoveBackBack()
                .getRemoveTShirt();
        softAssert.assertFalse(CartPage.isProductInCart("Sauce Labs Backpack"),
                "Рюкзак не удалился");
        softAssert.assertFalse(CartPage.isProductInCart("Sauce Labs Bolt T-Shirt"),
                "Футболка не удалена");
        softAssert.assertTrue(CartPage.isProductInCart("Sauce Labs Bike Light"),
                "Велосипед пропал после удаления");
        softAssert.assertTrue(CartPage.isProductInCart("Sauce Labs Fleece Jacket"),
                "Свитер пропал после удаления");
        softAssert.assertAll();
    }
}