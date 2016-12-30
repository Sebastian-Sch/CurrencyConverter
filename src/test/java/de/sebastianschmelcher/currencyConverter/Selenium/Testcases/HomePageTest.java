package de.sebastianschmelcher.currencyConverter.Selenium.Testcases;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.sebastianschmelcher.currencyConverter.Selenium.SeleniumTestBase;
import de.sebastianschmelcher.currencyConverter.Selenium.PageObjects.HomePage;
import de.sebastianschmelcher.currencyConverter.Selenium.PageObjects.RegisterPage;

public class HomePageTest extends SeleniumTestBase {
	
	@DataProvider(name = "testHome")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Currency" },
	   { "Converter" },
	 };
	}
	
	@Test(dataProvider = "testHome")
	public void testHome(String expectedTitle) {
		final HomePage homePage = new HomePage(driver);
		homePage.open();

		assertTrue(homePage.isCurrentPage());
		assertTrue(homePage.hasLinkToRegister());
		assertTrue(homePage.getPageTitle().contains(expectedTitle));

		RegisterPage registerPage = homePage.gotoRegister();
		assertTrue(registerPage.isCurrentPage());
	}
}