package de.sebastianschmelcher.currencyConverter.Selenium.PageObjects;

public class UnexpectedPageTransitionException extends RuntimeException
{
   private static final long serialVersionUID = 1L;

   private static final String MESSAGE = "Expected to move from '%s' to '%s' but landed on '%s' instead.";

   public UnexpectedPageTransitionException(final String originUrl, final String expectedTargetUrl, final String actualTargetUrl)
   {
      super(String.format(MESSAGE, originUrl, expectedTargetUrl, actualTargetUrl));
   }
}