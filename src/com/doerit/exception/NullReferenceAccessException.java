package com.doerit.exception;

public class NullReferenceAccessException extends Exception {

	private static final long serialVersionUID = 1L;

	public NullReferenceAccessException() {
	}

	public NullReferenceAccessException(String s) {
		super(s);
	}

	public NullReferenceAccessException(Throwable t) {
		super(t);
	}

}
