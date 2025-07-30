package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class BackpackCardPage extends BasePage {

    By addToCartButton = By.cssSelector("[data-test=add-to-cart]");
    By cart = By.cssSelector("[data-test=shopping-cart-badge]");

    public BackpackCardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BackpackCardPage open() {
        log.info("Open login page");
        driver.get(BASE_URL + "/inventory-item.html?id=5");
        return null;
    }

    @Override
    public BackpackCardPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    @Step("Добавление товара backPack в корзину из карточки товара")
    public BackpackCardPage addBackpackToCart() {
        log.info("Add backpack from card");
        WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        addButton.click();
        return this;
    }

    @Step("Нажатие и переход в корзину из карточки товара")
    public CartPage openCart() {
        log.info("Click cart");
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
        cartButton.click();
        return new CartPage(driver);
    }
}