package de.sebastianschmelcher.currencyConverter.Selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumProperty;
import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumPropertyService;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class SeleniumTestBase extends AbstractTestNGSpringContextTests {

	protected WebDriver driver;

	// @Rule
	// public TakeScreenshotOnFailure screenshotOnFailureRule = new
	// TakeScreenshotOnFailure();

	@Parameters("browser")
	@BeforeClass
	public void startBrowser(String browser) {

		String mode = SeleniumPropertyService.getPropertyValue(SeleniumProperty.mode);
		if ("grid".equals(mode)) {
			try {
				URL gridServer = new URL(SeleniumPropertyService.getPropertyValue(SeleniumProperty.gridserver));
				driver = new RemoteWebDriver(gridServer,
						getBrowserCapabilities(SeleniumPropertyService.getPropertyValue(SeleniumProperty.browser)));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("local".equals(mode)) {
			// Built in default driver, maybe change later
			driver = getBrowserDriver(browser);
		}
		if (driver == null) {
			System.out.println("No valid configuration.");
		}

		// Make sure there is a timeout so that tests don't block indefinitely
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// screenshotOnFailureRule.setDriver(this.driver);
	}

	@AfterClass
	public void shutdownBrowserAfterTest() {
		this.driver.close();
	}

	private DesiredCapabilities getBrowserCapabilities(String browserType) {
		switch (browserType) {
		case "firefox":
		case "ff":
			System.out.println("Opening firefox driver");
			return DesiredCapabilities.firefox();
		case "chrome":
			System.out.println("Opening chrome driver");
			return DesiredCapabilities.chrome();
		case "ie":
			System.out.println("Opening IE driver");
			return DesiredCapabilities.internetExplorer();
		default:
			System.out.println("browser : " + browserType + " is invalid.");
			return null;
		}
	}

	private WebDriver getBrowserDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			System.out.println("Opening chrome driver");
			System.setProperty("webdriver.chrome.driver",
					SeleniumPropertyService.getPropertyValue(SeleniumProperty.chromedriver));
			WebDriver chromeDriver = new ChromeDriver();
			// Cleanup browser state in case of leftovers from another session
			chromeDriver.manage().deleteAllCookies();
			return chromeDriver;
		/* only webdriver above this line are working correctly*/
		case "phantom":
			System.setProperty("phantomjs.binary.path",
					SeleniumPropertyService.getPropertyValue(SeleniumProperty.phantomdriver));
			return new PhantomJSDriver();
		case "firefox":
		case "ff":
			System.out.println("Opening firefox driver");
			return new FirefoxDriver();
		case "ie":
			System.out.println("Opening IE driver");
			/*
			 * http://stackoverflow.com/questions/23782891/selenium-webdriver-on
			 * -ie11
			 * 
			 * To get IE11 working: - enable protected mode for all zones
			 * (options : Tab security) - verify enhanced protection mode is
			 * disables (options: Tab advanced) - set NATIVE_EVENTS = false -
			 * set ENSURCE_CLEAN_SESSION = true - do not call anything related
			 * to cookies ( eg. chromeDriver.manage().deleteAllCookies() )
			 */
			System.setProperty("webdriver.ie.driver",
					SeleniumPropertyService.getPropertyValue(SeleniumProperty.iedriver));
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			return new InternetExplorerDriver(ieCapabilities);
		case "opera":
			System.setProperty("webdriver.opera.driver",
					SeleniumPropertyService.getPropertyValue(SeleniumProperty.operadriver));
			return new OperaDriver();
		case "operax":
			System.setProperty("webdriver.chrome.driver",
					SeleniumPropertyService.getPropertyValue(SeleniumProperty.operadriver));
			return new ChromeDriver();
		default:
			System.out.println("browser : " + browserType + " is invalid.");
			return null;
		}
	}
}