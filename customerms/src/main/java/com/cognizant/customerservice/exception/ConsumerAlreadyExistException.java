package com.cognizant.customerservice.exception;

/**
 * @author Sri Durga
 *
 */
public class ConsumerAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2862505141325062716L;

	public ConsumerAlreadyExistException() {
		super();
	}

	/**
	 * @param message
	 */
	public ConsumerAlreadyExistException(String message) {
		super(message);
	}

}
