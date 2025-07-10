package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {


    By title = By.cssSelector("[data-test=title]");

    private final String add_to_cart_pattern = "//div[text()='%s']/ancestor::" +
            "div[@data-test='inventory-item']//button[text()='Add to cart']";

    By backpackButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]");
    By bikeButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-bike-light]");
    By tShirtButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-bolt-t-shirt]");
    By fleeceJacketButton = By.cssSelector("[data-test=add-to-cart-sauce-labs-fleece-jacket]");
    By cartButton = By.cssSelector("[data-test=shopping-cart-badge]");
    By backpackCard = By.cssSelector("[data-test=inventory-item-name]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(add_to_cart_pattern, product))).click();
    }
//
//    public boolean isProductInCart(String product) {
//        return driver.findElement(By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']", product))).isDisplayed();
//    }

    //Добавление в корзину backPac
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

    //Нажатие и переход в корзину
    public void openCart() {
        driver.findElement(cartButton).click();
    }

    //Нажатие и переход в карточку товара backPack
    public void openCardBackpack() {
        driver.findElement(backpackCard).click();
    }
}