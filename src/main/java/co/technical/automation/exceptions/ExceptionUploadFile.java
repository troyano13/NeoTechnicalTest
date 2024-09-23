package co.technical.automation.exceptions;

import co.technical.automation.util.constants.ExceptionMessages;

public class ExceptionUploadFile extends AssertionError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionUploadFile(String message, Throwable cause) {
		super(ExceptionMessages.ERROR_UPLOAD_FILE, cause);
	}
}

