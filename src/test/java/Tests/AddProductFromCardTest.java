package Tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductFromCardTest extends BaseTest {

    @Test(testName = "Проверка добавления товара в корзину из карточки товара")
    @Owner("Martyanova O.I")
    @Description("Проверка добавления товара в корзину из карточки товара")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("add from card to cart in saucedemo")
    @Story("Добавление в корзину")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-5")
    public void checkAddProductInCartFromCard() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCardBackpack();
        backpackCardPage.addBackpackToCart();
        backpackCardPage.openCart();
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
