package de.sebastianschmelcher.currencyConverter.Selenium.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;


public abstract class SiteObject
{

	protected WebDriver driver;
	protected FluentWait<WebDriver> wait1Second;
	protected FluentWait<WebDriver> wait2Seconds;
	protected FluentWait<WebDriver> wait5Seconds;
	protected FluentWait<WebDriver> wait20Seconds;

	protected SiteObject(WebDriver driver)
	{
		this.driver = driver;

		wait1Second = new FluentWait<WebDriver>(driver).withTimeout(1, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS);
		wait2Seconds = new FluentWait<WebDriver>(driver).withTimeout(2, TimeUnit.SECONDS).pollingEvery(250, TimeUnit.MILLISECONDS);
		wait5Seconds = new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
		wait20Seconds = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
	}

	protected WebElement findById(String elementId)
	{
		return driver.findElement(By.id(elementId));
	}

	protected WebElement findByCss(String cssSelector)
	{
		return driver.findElement(By.cssSelector(cssSelector));
	}

	protected WebElement findByClassName(String className)
	{
		return driver.findElement(By.className(className));
	}

	public WebElement findByXpath(String path)
	{
		return driver.findElement(By.xpath(path));
	}

	public WebElement findParent(WebElement child)
	{
		return child.findElement(By.xpath(".."));
	}
}