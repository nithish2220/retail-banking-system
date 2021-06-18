package com.cognizant.bankmvc.exception;

/**
 * @author S Nithish Kumar
 *
 */
public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
	}

	/**
	 * @param message
	 */
	public CustomerNotFoundException(String message) {
		super(message);
	}

}
