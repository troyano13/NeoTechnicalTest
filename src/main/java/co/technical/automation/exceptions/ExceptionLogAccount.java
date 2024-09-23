package co.technical.automation.exceptions;

import co.technical.automation.util.constants.ExceptionMessages;

public class ExceptionLogAccount extends AssertionError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionLogAccount(String message, Throwable cause) {
		super(ExceptionMessages.ERROR_LOGIN, cause);
	}
}

