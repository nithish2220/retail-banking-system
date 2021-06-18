package com.cognizant.accountservice.exceptionhandling;

/**
 * @author Pulkit Gupta
 *
 */
public class WrongDateProvidedException extends Exception{


	private static final long serialVersionUID = 1L;
	
	public WrongDateProvidedException() {
		super();
	}


	/**
	 * @param msg
	 */
	public WrongDateProvidedException(String msg) {
		super(msg);
	}

}
