package de.sebastianschmelcher.currencyConverter.Selenium.Infrastructure;

public class SetupFailureException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public SetupFailureException(String message)
	{
		super(message);
	}

}