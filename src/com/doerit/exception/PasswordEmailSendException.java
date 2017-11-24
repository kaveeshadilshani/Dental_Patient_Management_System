package com.doerit.exception;

public class PasswordEmailSendException extends Exception {

	private static final long serialVersionUID = 1L;

	public PasswordEmailSendException() {
		super();
	}

	public PasswordEmailSendException(String message) {
		super(message);
	}

	public PasswordEmailSendException(Throwable cause) {
		super(cause);
	}

}
