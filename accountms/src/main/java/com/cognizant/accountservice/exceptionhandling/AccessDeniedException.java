package com.cognizant.accountservice.exceptionhandling;

/**
 * @author Pulkit Gupta
 *
 */
public class AccessDeniedException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	
	public AccessDeniedException() {
		super();
	}

	/**
	 * @param message
	 */
	public AccessDeniedException(String message) {
		super(message);
	}

}
