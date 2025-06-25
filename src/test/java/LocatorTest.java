import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class LocatorTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkLocators() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.className("product_sort_container"));
        driver.findElements(By.tagName("li"));
        driver.findElement(By.linkText("Sauce Labs Onesie"));
        driver.findElement(By.partialLinkText("Twit"));

        // XPath локаторы
        // 1. Поиск по атрибуту (точное совпадение значения атрибута) кнопка корзины
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        // 2. Поиск по тексту (по точному совпадению видимого текста элемента) заголовок "Products"
        driver.findElement(By.xpath("//span[text()='Products']"));
        // 3. Частичное совпадение атрибута (все карточки товара с inventory)
        driver.findElements(By.xpath("//div[contains(@class,'inventory')]"));
        // 4. Частичное совпадение текста (все товары с "Labs")
        driver.findElement(By.xpath("//div[contains(text(),'Labs')]"));
        // 5. Ancestor (родитель карточки товара)
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']//ancestor::div[@class='inventory_item']"));
        // 6. Descendant (потомок карточки товара - кнопки Add to cart)
        driver.findElements(By.xpath("//div[@class='inventory_item']//descendant::button"));
        // 7. Following (после элемента)
        driver.findElements(By.xpath("//div[@class='inventory_item'][1]//following::div"));
        // 8. Parent (поиск родителя элемента)
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/parent::a"));
        // 9. Preceding (ДО текущего элемента)
        driver.findElements(By.xpath("//div[@class='inventory_item'][last()]//preceding::div"));
        // 10. AND комбинирование условий - "Add to cart" для футболки
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt' and @name='add-to-cart-sauce-labs-bolt-t-shirt']"));
        // CSS локаторы
        // 1. CSS.class по классу
        driver.findElement(By.cssSelector(".shopping_cart_link"));
        // 2. .class1.class2 по нескольким классам
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small"));
        // 3. .class1 .class2 поиск элементов с классом class2 внутри элементов с классом class1.
        driver.findElements(By.cssSelector(".inventory_item .inventory_item_name"));
        // 4. #id
        driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        // 5. tagname всех элементов с указанным тегом (все кнопки)
        driver.findElements(By.cssSelector("button"));
        // 6. tagname.class тэг + класс (иконка корзины как класс а)
        driver.findElement(By.cssSelector("a.shopping_cart_link"));
        // 7. [attribute=value] атрибут точно равен значению data test qa и тд
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"));
        // 8. [attribute~=value] атрибут содержит указанное слово
        driver.findElement(By.cssSelector("[class~='inventory_item_name']"));
        // 9. [attribute|=value] атрибут начинается с указанного слова
        driver.findElements(By.cssSelector("[class|='inventory']"));
        // 10. [attribute^=value] атрибут начинается с указанной строки.
        driver.findElements(By.cssSelector("[class^='inventory_item_']"));
        // 11. [attribute$=value] атрибут заканчивается указанной строкой
        driver.findElement(By.cssSelector("[class$='container']"));
        // 12. [attribute*=value]по части значения
        driver.findElements(By.cssSelector("[class*='cart']"));

        driver.quit();
    }
}