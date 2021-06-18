package com.cognizant.accountservice.exceptionhandling;

/**
 * @author Pulkit Gupta
 *
 */
public class WrongDateFormatException extends Exception{
	

	private static final long serialVersionUID = 1L;
	public WrongDateFormatException() {
		super();
	}
	/**
	 * @param msg
	 */
	public WrongDateFormatException(String msg) {
		super(msg);
	}
}
