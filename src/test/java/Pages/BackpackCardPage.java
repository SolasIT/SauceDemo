package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackpackCardPage extends BasePage {

    By addToCartButton = By.cssSelector("[data-test=add-to-cart]");
    By cart = By.cssSelector("[data-test=shopping-cart-badge]");

    public BackpackCardPage(WebDriver driver) {
        super(driver);
    }

    //Добавление товара backPack в корзину из карточки товара
    public void addBackpackToCart() {
        driver.findElement(addToCartButton).click();
    }

    //Нажатие и переход в  из карточки товара
    public void openCart() {
        driver.findElement(cart).click();
    }
}