package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class CartPage extends BasePage {


    By cart = By.xpath("//span[text()='Your Cart']");
    By itemBackPack = By.xpath("//div[text()='Sauce Labs Backpack']");
    By removeBackPack = By.cssSelector("[data-test=remove-sauce-labs-backpack]");
    By itemTShirt = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    By removeTShirt = By.cssSelector("[data-test=remove-sauce-labs-bolt-t-shirt]");
    By itemBike = By.xpath("//div[text()='Sauce Labs Bike Light']");
    By itemFleeceJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Поиск товара в корзине")
    public static boolean isProductInCart(String product) {
        log.info("Searching item in cart");
        try {
            //найти и проверить видимость элемента
            return driver.findElement(By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']", product)))
                    .isDisplayed();
        } catch (NoSuchElementException e) {
            // Если элемент не найден - возвращаем false
            return false;
        } catch (Exception e) {
            // Другие ошибки
            return false;
        }
    }

    @Override
    public CartPage open() {
        log.info("Open login page");
        driver.get(BASE_URL + "/cart.html");
        return this;
    }

    @Step("Страница корзины")
    public String getTitle() {
        return driver.findElement(cart).getText();
    }

    @Step("Рюкзак в корзине")
    public String getItemBackPack() {
        return driver.findElement(itemBackPack).getText();
    }

    @Override
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public String getItemTShirt() {
        return driver.findElement(itemTShirt).getText();
    }

    @Step("Удаление из корзины товара backPack")
    public CartPage getRemoveBackBack() {
        log.info("Remove back pack");
        driver.findElement(removeBackPack).click();
        return this;
    }

    public String getItemBike() {
        return driver.findElement(itemBike).getText();
    }

    public String getItemFleeceJacket() {
        return driver.findElement(itemFleeceJacket).getText();
    }

    @Step("Удаление из корзины товара t-shirt")
    public CartPage getRemoveTShirt() {
        log.info("Remove T shirt");
        driver.findElement(removeTShirt).click();
        return this;
    }
}