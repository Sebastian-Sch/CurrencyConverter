package de.sebastianschmelcher.currencyConverter.Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumProperty;
import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumPropertyService;


public abstract class BasePageObject extends SiteObject
{

	private String baseUrl;
	private HeaderSiteObject headerSiteObject;

	protected BasePageObject(WebDriver driver)
	{
		super(driver);
		this.baseUrl = ensureTrailingSlash(SeleniumPropertyService.getPropertyValue(SeleniumProperty.baseurl));
		this.headerSiteObject = new HeaderSiteObject(driver);
	}

	public boolean isCurrentPage()
	{
		return this.driver.getCurrentUrl().endsWith(this.getUrlSuffix());
	}

	public void open()
	{
		driver.get(getPageUrl());
	}

	protected abstract String getUrlSuffix();

	protected String getPageUrl()
	{
		return String.valueOf(this.baseUrl) + this.getUrlSuffix();
	}

	protected <T extends BasePageObject> T confirmPageIsCorrect(final T expectedPage)
	{
		if (!expectedPage.isCurrentPage())
		{
			final String originUrl = this.getPageUrl();
			final String expectedTargetUrl = expectedPage.getPageUrl();
			final String actualTargetUrl = this.driver.getCurrentUrl();
			throw new UnexpectedPageTransitionException(originUrl, expectedTargetUrl, actualTargetUrl);
		}
		return expectedPage;
	}

	public HeaderSiteObject getHeader()
	{
		return headerSiteObject;
	}

	private String ensureTrailingSlash(String url)
	{
		if (url.endsWith("/"))
		{
			return url;
		}
		return url.concat("/");
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}