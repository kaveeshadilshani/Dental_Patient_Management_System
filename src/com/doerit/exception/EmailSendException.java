package com.doerit.exception;

public class EmailSendException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmailSendException(String string) {
		super(string);
	}	
}
