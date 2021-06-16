package com.cognizant.accountservice.service;

import java.text.ParseException;
import java.util.List;

import com.cognizant.accountservice.exceptionhandling.WrongDateFormatException;
import com.cognizant.accountservice.exceptionhandling.WrongDateProvidedException;
import com.cognizant.accountservice.model.Account;
import com.cognizant.accountservice.model.AccountCreationStatus;
import com.cognizant.accountservice.model.AccountInput;
import com.cognizant.accountservice.model.AuthenticationResponse;

public interface AccountService {
	
	public AccountCreationStatus createAccount(String customerId, Account account);

	public List<Account> getCustomerAccount(String token, String customerId);

	public Account getAccount(long accountId);

	public AuthenticationResponse hasPermission(String token);

	public AuthenticationResponse hasEmployeePermission(String token);

	public AuthenticationResponse hasCustomerPermission(String token);

	public Account updateDepositBalance(AccountInput accountInput);

	public Account updateBalance(AccountInput accountInput);
	
	public List<Account> getAllAccounts();

	public List<String> getAccountStatement(String from, String to)throws WrongDateFormatException, WrongDateProvidedException, ParseException;
	public List<String> getAccountStatement() throws WrongDateFormatException, WrongDateProvidedException, ParseException;

}
