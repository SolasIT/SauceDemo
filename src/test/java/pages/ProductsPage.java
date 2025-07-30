package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class ProductsPage extends BasePage {

    By title = By.cssSelector("[data-test=title]");

    By backpackButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]");
    By bikeButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-bike-light]");
    By tShirtButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-bolt-t-shirt]");
    By fleeceJacketButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-fleece-jacket]");
    By cartButton = By.cssSelector("[data-test=shopping-cart-badge]");
    By backpackCard = By.cssSelector("[data-test=inventory-item-name]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage open() {
        log.info("Open login page");
        driver.get(BASE_URL + "/inventory.html");
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    @Step("Страница с товарами")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Добавить {product} в корзину")
    public ProductsPage addToCart(String product) {
        log.info("Add {} to cart", product);
        String add_to_cart_pattern = "//div[text()='%s']/ancestor::" +
                "div[@data-test='inventory-item']//button[text()='Add to cart']";
        driver.findElement(By.xpath(String.format(add_to_cart_pattern, product))).click();
        return this;
    }
//
//    public boolean isProductInCart(String product) {
//        return driver.findElement(By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']", product))).isDisplayed();
//    }

    //Добавление в корзину backPac
    @Step("Добавление в корзину backPac")
    public void addBackpack() {
        driver.findElement(backpackButton).click();
    }

    //Добавление в корзину bike
    public void addBike() {
        driver.findElement(bikeButton).click();
    }

    //Добавление в корзину T-shirt
    public void addTShirt() {
        driver.findElement(tShirtButton).click();
    }

    //Добавление в корзину fleece jacket
    public void addFleeceJacket() {
        driver.findElement(fleeceJacketButton).click();
    }

    @Step("Переход в корзину")
    public CartPage openCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    //Нажатие и переход в карточку товара backPack
    @Step("Нажатие и переход в карточку товара backPack")
    public BackpackCardPage openCardBackpack() {
        driver.findElement(backpackCard).click();
        return new BackpackCardPage(driver);
    }
}