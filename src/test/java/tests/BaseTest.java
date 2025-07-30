package tests;

import pages.BackpackCardPage;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

@Listeners(tests.TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    BackpackCardPage backpackCardPage;
    SoftAssert softAssert = new SoftAssert();

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);//отключает сервис сохранения паролей
            chromePrefs.put("profile.password_manager_enabled", false);//отключает встроенный менеджер паролей.
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            options.addArguments(("--headless"));
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments(("--headless"));
            driver = new EdgeDriver(options);
        }
        softAssert = new SoftAssert();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        backpackCardPage = new BackpackCardPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            utils.AllureUtils.takeScreenshot(driver);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}