package de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SeleniumPropertyService
{

	private static final String SELENIUM_PROPERTIES = "selenium.properties";

	private static SeleniumPropertyService instance;

	private Properties seleniumProperties;

	private SeleniumPropertyService()
	{
		// Singleton
	}

	private static SeleniumPropertyService getInstance()
	{
		if (instance == null)
		{
			instance = new SeleniumPropertyService();

			instance.seleniumProperties = new Properties();
			instance.loadProperties(instance.seleniumProperties, SELENIUM_PROPERTIES);
		}
		return instance;
	}

	public static String getPropertyValue(SeleniumProperty property)
	{
		return getInstance().getSeleniumProperty(property.name());

	}

	private String getSeleniumProperty(String propertyKey)
	{
		return seleniumProperties.getProperty(propertyKey);
	}

	private void loadProperties(Properties toLoad, String propertyLocation)
	{
		try (InputStream propertyStream = getClass().getClassLoader().getResourceAsStream(propertyLocation))
		{
			if (propertyStream == null)
			{
				throw new SetupFailureException("Couldn't read properties for selenium tests: Properties file not found. Aborting!");
			}

			toLoad.load(propertyStream);
		}
		catch (IOException e)
		{
			throw new SetupFailureException("Couldn't read properties for selenium tests, aborting!");
		}
	}

}