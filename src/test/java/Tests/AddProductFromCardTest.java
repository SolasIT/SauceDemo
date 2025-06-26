package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductFromCardTest extends BaseTest {

    //Проверка добавления товара в корзину из карточки товара
    @Test
    public void checkAddProductInCartFromCard() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCardBackpack();
        backpackCardPage.addBackpackToCart();
        backpackCardPage.openCart();
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
