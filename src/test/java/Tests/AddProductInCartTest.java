package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductInCartTest extends BaseTest {

    //Проверка добавления товара в корзину с главной страницы
    @Test
    public void checkAddProductInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addBackpack();
        productsPage.openCart();
        Assert.assertEquals(
                cartPage.getTitle(),
                "Your Cart",
                "Не удалось перейти в корзину");
        Assert.assertEquals(
                cartPage.getItemBackPack(),
                "Sauce Labs Backpack",
                "Не удалось добавить рюкзак в корзину");
    }
}