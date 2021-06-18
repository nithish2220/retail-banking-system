package com.cognizant.authenticationservice.exceptionhandling;

/**
 * @author Isha Rahal
 *
 */
public class AppUserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AppUserNotFoundException() {
		super();
	}

	public AppUserNotFoundException(final String message) {
		super(message);
	}
}