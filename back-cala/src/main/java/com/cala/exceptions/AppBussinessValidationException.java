package com.cala.exceptions;

public class AppBussinessValidationException extends Exception {

	private static final long serialVersionUID = -7594475792945484177L;

	private String errorMessage;
	
	public AppBussinessValidationException (String errorMessage) {
		setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
