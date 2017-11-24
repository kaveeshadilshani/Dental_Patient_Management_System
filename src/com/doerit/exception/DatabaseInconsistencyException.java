package com.doerit.exception;

public class DatabaseInconsistencyException extends Exception {

	private static final long serialVersionUID = 1L;

	public DatabaseInconsistencyException() {
		super();
	}

	public DatabaseInconsistencyException(String message) {
		super(message);
	}

	public DatabaseInconsistencyException(Throwable cause) {
		super(cause);
	}

}
