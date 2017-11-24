package com.doerit.exception;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemNotFoundException() {
		super();
	}

	public ItemNotFoundException(String s){
		super(s);
	}

	public ItemNotFoundException(Throwable t) {
		super(t);
	}

}
