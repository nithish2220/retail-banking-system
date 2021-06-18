package com.cognizant.accountservice.service;

import java.text.ParseException;
import java.util.List;

import com.cognizant.accountservice.exceptionhandling.WrongDateFormatException;
import com.cognizant.accountservice.exceptionhandling.WrongDateProvidedException;
import com.cognizant.accountservice.model.Account;
import com.cognizant.accountservice.model.AccountCreationStatus;
import com.cognizant.accountservice.model.AccountInput;
import com.cognizant.accountservice.model.AuthenticationResponse;

/**
 * @author Pulkit Gupta
 *
 */
public interface AccountService {
	
	/**
	 * @param customerId
	 * @param account
	 * @return AccountCreationStatus
	 */
	public AccountCreationStatus createAccount(String customerId, Account account);

	/**
	 * @param token
	 * @param customerId
	 * @return List<Account>
	 */
	public List<Account> getCustomerAccount(String token, String customerId);

	/**
	 * @param accountId
	 * @return Account
	 */
	public Account getAccount(long accountId);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasPermission(String token);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasEmployeePermission(String token);

	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasCustomerPermission(String token);

	/**
	 * @param accountInput
	 * @return Account
	 */
	public Account updateDepositBalance(AccountInput accountInput);

	/**
	 * @param accountInput
	 * @return Account
	 */
	public Account updateBalance(AccountInput accountInput);
	
	/**
	 * @return List<Account>
	 */
	public List<Account> getAllAccounts();

	/**
	 * @param from
	 * @param to
	 * @return List<String>
	 * @throws WrongDateFormatException
	 * @throws WrongDateProvidedException
	 * @throws ParseException
	 */
	public List<String> getAccountStatement(String from, String to)throws WrongDateFormatException, WrongDateProvidedException, ParseException;
	
	/**
	 * @return List<String>
	 * @throws WrongDateFormatException
	 * @throws WrongDateProvidedException
	 * @throws ParseException
	 */
	public List<String> getAccountStatement() throws WrongDateFormatException, WrongDateProvidedException, ParseException;

}
