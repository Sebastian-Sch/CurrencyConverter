package de.sebastianschmelcher.currencyConverter.Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumProperty;
import de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure.SeleniumPropertyService;


public class HomePage extends BasePageObject
{

	public HomePage(final WebDriver driver)
	{
		super(driver);
	}

	@Override
	protected String getUrlSuffix()
	{
		return "";
	}

	@Override
	public boolean isCurrentPage()
	{
		final String baseUrl = SeleniumPropertyService.getPropertyValue(SeleniumProperty.baseurl);
		return this.driver.getCurrentUrl().equals(baseUrl);
	}
	
	public boolean hasLinkToRegister()
	{
		return getRegisterLink() != null;
	}
	
	public RegisterPage gotoRegister()
	{
		getRegisterLink().click();
		RegisterPage registerPage = new RegisterPage(driver);
		return confirmPageIsCorrect(registerPage);
	}	
	
	private WebElement getRegisterLink()
	{
		return findByCss(".linkRegister");
	}
}