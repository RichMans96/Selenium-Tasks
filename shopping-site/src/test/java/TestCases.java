
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class TestCases {

    private static RemoteWebDriver driver;
    final static Logger LOGGER = Logger.getGlobal();


    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/webdriver/geckodriver.exe");
        FirefoxOptions fOptions = new FirefoxOptions();
        fOptions.setHeadless(false);
        driver = new FirefoxDriver(fOptions);
        fOptions.addPreference("profile.default_content_setting_values.cookies", 2);
        fOptions.addPreference("network.cookie.cookieBehavior", 2);
        fOptions.addPreference("profile.block_third_party_cookies", true);
        driver.manage().window().setSize(new Dimension(1366, 768));

    }

    @Before
    public void setup() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        try {
            driver.get(HomePage.URL);
        } catch (TimeoutException e) {
            System.out.println("Page: " + HomePage.URL + " did not load within 30 seconds!");
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void searchForBlouseTest() {
        LOGGER.warning("connecting to site...");

        HomePage home = PageFactory.initElements(driver, HomePage.class);

        home.searchFor("Blouse");

        new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("body.search.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 ul.product_list.grid.row:nth-child(3) li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line div.product-container div.right-block h5:nth-child(1) > a.product-name")));
        WebElement blouse = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]"));

        assertEquals("Blouse", blouse.getText());
    }

}
