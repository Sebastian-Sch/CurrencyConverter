package de.sebastianschmelcher.currencyConverter.Selenium.Testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.sebastianschmelcher.currencyConverter.Selenium.SeleniumTestBase;
import de.sebastianschmelcher.currencyConverter.Selenium.PageObjects.HomePage;
import de.sebastianschmelcher.currencyConverter.Selenium.PageObjects.RegisterPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HomePageTest extends SeleniumTestBase
{
	@Test
	public void testHome()
	{
		final HomePage homePage = new HomePage(driver);
		homePage.open();
		
		assertTrue(homePage.isCurrentPage());
		assertTrue(homePage.hasLinkToRegister());
		
		RegisterPage registerPage = homePage.gotoRegister();
		assertTrue(registerPage.isCurrentPage());
	}
}