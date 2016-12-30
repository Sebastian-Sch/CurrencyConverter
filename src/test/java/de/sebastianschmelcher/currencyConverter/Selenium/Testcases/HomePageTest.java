package de.sebastianschmelcher.currencyConverter.Selenium.Testcases;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import de.sebastianschmelcher.currencyConverter.Selenium.SeleniumTestBase;
import de.sebastianschmelcher.currencyConverter.Selenium.PageObjects.HomePage;
import de.sebastianschmelcher.currencyConverter.Selenium.PageObjects.RegisterPage;

public class HomePageTest extends SeleniumTestBase {

	@Test
	public void testHome() {
		final HomePage homePage = new HomePage(driver);
		homePage.open();

		assertTrue(homePage.isCurrentPage());
		assertTrue(homePage.hasLinkToRegister());

		RegisterPage registerPage = homePage.gotoRegister();
		assertTrue(registerPage.isCurrentPage());
	}
}