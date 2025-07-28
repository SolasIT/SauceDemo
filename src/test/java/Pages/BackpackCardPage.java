package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BackpackCardPage extends BasePage {

    By addToCartButton = By.cssSelector("[data-test=add-to-cart]");
    By cart = By.cssSelector("[data-test=shopping-cart-badge]");

    public BackpackCardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BackpackCardPage open() {
        driver.get(BASE_URL + "/inventory-item.html?id=5");
        return null;
    }

    @Override
    public BackpackCardPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        return null;
    }

    @Step("Добавление товара backPack в корзину из карточки товара")
    public BackpackCardPage addBackpackToCart() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    @Step("Нажатие и переход в корзину из карточки товара")
    public CartPage openCart() {
        driver.findElement(cart).click();
        return new CartPage(driver);
    }
}