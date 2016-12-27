package de.sebastianschmelcher.currencyConverter.Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.TakeScreenshotOnFailure;

public class SeleniumTestBase
{

	protected WebDriver driver;

	@Rule
	public TakeScreenshotOnFailure screenshotOnFailureRule = new TakeScreenshotOnFailure();

	@Before
	public void startBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\repositories\\chromedriver.exe");
		// Built in default driver, maybe change later
		driver = new ChromeDriver();
		// Cleanup browser state in case of leftovers from another session
		driver.manage().deleteAllCookies();
		// Make sure there is a timeout so that tests don't block indefinitely
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		screenshotOnFailureRule.setDriver(this.driver);
	}

	@After
	public void shutdownBrowserAfterTest()
	{
	   this.driver.close();
	}

}