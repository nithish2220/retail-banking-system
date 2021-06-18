package com.cognizant.transactionservice.service;

import com.cognizant.transactionservice.util.AccountInput;
import com.cognizant.transactionservice.util.TransactionInput;

/**
 * @author Dhananjay Batra
 *
 */
public interface TransactionServiceInterface {

	/**
	 * @param token
	 * @param transactionInput
	 * @return boolean
	 */
	public boolean makeTransfer(String token, TransactionInput transactionInput);

	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	public boolean makeWithdraw(String token, AccountInput accountInput);

	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	public boolean makeDeposit(String token, AccountInput accountInput);
	
	/**
	 * @param token
	 * @param accountInput
	 * @return boolean
	 */
	public boolean makeServiceCharges(String token, AccountInput accountInput);
}
