package com.cognizant.accountservice.exceptionhandling;

/**
 * @author Pulkit Guptas
 *
 */
public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super();
	}

	/**
	 * @param message
	 */
	public AccountNotFoundException(String message) {
		super(message);
	}
}
