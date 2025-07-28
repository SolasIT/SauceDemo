package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @Override
    public CartPage open() {
        driver.get(BASE_URL + "/cart.html");
        return this;
    }

    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
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

    @Step("Удаление из корзины товара backPack")
    public CartPage getRemoveBackBack() {
        driver.findElement(removeBackPack).click();
        return this;
    }

    public String getItemTShirt() {
        return driver.findElement(itemTShirt).getText();
    }

    @Step("Удаление из корзины товара t-shirt")
    public CartPage getRemoveTShirt() {
        driver.findElement(removeTShirt).click();
        return this;
    }

    public String getItemBike() {
        return driver.findElement(itemBike).getText();
    }

    public String getItemFleeceJacket() {
        return driver.findElement(itemFleeceJacket).getText();
    }

    @Step("Поиск товара в корзине")
    public static boolean isProductInCart(String product) {
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
}