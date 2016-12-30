package de.sebastianschmelcher.currencyConverter.Selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumProperty;
import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumPropertyService;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class SeleniumTestBase extends AbstractTestNGSpringContextTests 
{

	protected WebDriver driver;

//	@Rule
//	public TakeScreenshotOnFailure screenshotOnFailureRule = new TakeScreenshotOnFailure();

	@BeforeClass
	public void startBrowser()
	{
		
		
		String mode = SeleniumPropertyService.getPropertyValue(SeleniumProperty.mode);
		if("grid".equals(mode)){
			try {
				URL gridServer = new URL(SeleniumPropertyService.getPropertyValue(SeleniumProperty.gridserver));
				driver = new RemoteWebDriver(gridServer, getBrowserCapabilities(SeleniumPropertyService.getPropertyValue(SeleniumProperty.browser)));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("local".equals(mode)){
			System.setProperty("webdriver.chrome.driver", SeleniumPropertyService.getPropertyValue(SeleniumProperty.chromedriver));
			// Built in default driver, maybe change later
			driver = new ChromeDriver();			
		}
		if(driver == null){
			System.out.println("No valid configuration.");
		}
		
		
		// Cleanup browser state in case of leftovers from another session
		driver.manage().deleteAllCookies();
		// Make sure there is a timeout so that tests don't block indefinitely
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		screenshotOnFailureRule.setDriver(this.driver);
	}

	@AfterClass
	public void shutdownBrowserAfterTest()
	{
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
}