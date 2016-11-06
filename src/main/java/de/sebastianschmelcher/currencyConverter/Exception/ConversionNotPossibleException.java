package de.sebastianschmelcher.currencyConverter.Exception;

public class ConversionNotPossibleException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ConversionNotPossibleException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
