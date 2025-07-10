package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackpackCardPage extends BasePage {

    By addToCartButton = By.cssSelector("[data-test=add-to-cart]");
    By cart = By.cssSelector("[data-test=shopping-cart-badge]");

    public BackpackCardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавление товара backPack в корзину из карточки товара")
    public void addBackpackToCart() {
        driver.findElement(addToCartButton).click();
    }

    @Step("Нажатие и переход в корзину из карточки товара")
    public void openCart() {
        driver.findElement(cart).click();
    }
}