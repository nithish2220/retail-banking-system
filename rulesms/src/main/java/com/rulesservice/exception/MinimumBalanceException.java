package com.rulesservice.exception;

/**
 * @author Saaketh
 *
 */
public class MinimumBalanceException extends RuntimeException{

	/**
	 * MinimumBalance Exception
	 */
	private static final long serialVersionUID = 1L;

	public MinimumBalanceException() {
		super();
	}

	/**
	 * @param message
	 */
	public MinimumBalanceException(String message) {
		super(message);
	}

	
	
}
