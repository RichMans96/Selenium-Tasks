import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pages.CreateUserPage;
import pages.Homepage;
import pages.Login;

public class TestCases {


	private static ExtentReports extent;
	private static ExtentTest test;
	private static RemoteWebDriver driver;
	private static Logger LOGGER = Logger.getGlobal();

	private final String uName = "Test";
	private final String pWord = "Test1";


	@BeforeClass
	public static void init() {
		extent = new ExtentReports("src/test/resources/reports/report1.html", true);
		test = extent.startTest("ExtentDemo");
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
			driver.get(Homepage.URL);
		} catch (TimeoutException e) {
			System.out.println("Page: " + Homepage.URL + " did not load within 30 seconds!");
		}
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
		extent.close();

	}


	@Test
	public void createUserAndLogin() throws InterruptedException {
		LOGGER.warning("Connecting to The Demo Site....");

		Homepage home = PageFactory.initElements(driver, Homepage.class);
		
		CreateUserPage user = PageFactory.initElements(driver, CreateUserPage.class);

		Login passInfo = PageFactory.initElements(driver, Login.class);

		home.navUserPage();

		user.createUser(uName, pWord);

		home.navLoginPage();

		passInfo.loginInfo(uName, pWord);

		assertEquals("**Successful Login**", home.showLoginStatus());

	}

	
	
}
