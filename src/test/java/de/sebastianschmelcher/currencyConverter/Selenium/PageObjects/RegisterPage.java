package de.sebastianschmelcher.currencyConverter.Selenium.PageObjects;

import org.openqa.selenium.WebDriver;


public class RegisterPage extends BasePageObject
{

	public RegisterPage(final WebDriver driver)
	{
		super(driver);
	}

	@Override
	protected String getUrlSuffix()
	{
		return "/register";
	}	
}