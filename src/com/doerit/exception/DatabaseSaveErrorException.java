package com.doerit.exception;

public class DatabaseSaveErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public DatabaseSaveErrorException() {
		super();
	}

	public DatabaseSaveErrorException(String message) {
		super(message);
	}

	public DatabaseSaveErrorException(Throwable cause) {
		super(cause);
	}

}
