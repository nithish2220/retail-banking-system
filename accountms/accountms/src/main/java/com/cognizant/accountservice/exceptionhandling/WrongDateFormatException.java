package com.cognizant.accountservice.exceptionhandling;

public class WrongDateFormatException extends Exception{
	

	private static final long serialVersionUID = 1L;
	public WrongDateFormatException() {
		super();
	}
	public WrongDateFormatException(String msg) {
		super(msg);
	}
}
