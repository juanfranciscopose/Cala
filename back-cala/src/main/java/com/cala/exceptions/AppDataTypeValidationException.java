package com.cala.exceptions;

public class AppDataTypeValidationException extends Exception {

	private static final long serialVersionUID = 7730291504603344628L;
	
	private String errorMessage;
	
	public AppDataTypeValidationException (String errorMessage) {
		setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
