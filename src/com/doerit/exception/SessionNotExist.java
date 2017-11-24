package com.doerit.exception;

public class SessionNotExist extends Exception {

	private static final long serialVersionUID = 1L;

	public SessionNotExist() {
	}

	public SessionNotExist(String s) {
		super(s);
	}

	public SessionNotExist(Throwable t) {
		super(t);
	}

}
