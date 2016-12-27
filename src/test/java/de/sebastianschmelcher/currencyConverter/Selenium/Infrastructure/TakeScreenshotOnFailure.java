package de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TakeScreenshotOnFailure extends TestWatcher
{
	private WebDriver driver;

	private String saveDir;

	public TakeScreenshotOnFailure()
	{
		saveDir = "C:/selenium/";
	}

	@Override
	protected void failed(final Throwable throwable, final Description description)
	{
		if (this.driver == null)
		{
			throw new IllegalStateException(
					"WebDriver was not initialised. Please call setWebDriver(WebDriver) before executing tests.");
		}
		if (this.driver instanceof TakesScreenshot)
		{
			this.saveScreenshot((TakesScreenshot) this.driver, this.getTargetPNGFile(description));
		}
	}

	private void saveScreenshot(final TakesScreenshot screenshotDriver, final File targetPNGFile)
	{
		final byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
		try
		{
			System.out.println("Saving screen shot of failed test to " + targetPNGFile);
			FileUtils.writeByteArrayToFile(targetPNGFile, screenshot);
		}
		catch (final IOException ioException)
		{
			throw new RuntimeException("Error writing web page screenshot to file!", ioException);
		}
	}

	private File getTargetPNGFile(final Description description)
	{
		final Class<?> testClass = description.getTestClass();
		final File targetDir = new File(saveDir, testClass.getName());
		final String fileName = String.valueOf(description.getMethodName()) + ".png";
		return new File(targetDir, fileName);
	}

	public void setDriver(final WebDriver driver)
	{
		this.driver = driver;
	}
}