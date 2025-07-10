package Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductInCartTest extends BaseTest {

    @Test(testName = "Проверка корзины", description = "Проверка добавления товара в корзину с главной страницы")
    public void checkAddProductInCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addBackpack();
        productsPage.openCart();
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