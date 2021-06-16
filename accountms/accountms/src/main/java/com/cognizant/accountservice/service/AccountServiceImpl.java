package com.cognizant.accountservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.accountservice.exceptionhandling.AccessDeniedException;
import com.cognizant.accountservice.exceptionhandling.AccountNotFoundException;
import com.cognizant.accountservice.exceptionhandling.WrongDateFormatException;
import com.cognizant.accountservice.exceptionhandling.WrongDateProvidedException;
import com.cognizant.accountservice.feignclient.AuthFeignClient;
import com.cognizant.accountservice.feignclient.TransactionFeign;
import com.cognizant.accountservice.model.Account;
import com.cognizant.accountservice.model.AccountCreationStatus;
import com.cognizant.accountservice.model.AccountInput;
import com.cognizant.accountservice.model.AuthenticationResponse;
import com.cognizant.accountservice.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	private AuthFeignClient authFeignClient;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionFeign transactionFeign;


	//create customer aaccount
	@Override
	public AccountCreationStatus createAccount(String customerId, Account account) {
		accountRepository.save(account);
		AccountCreationStatus accountCreationStatus = new AccountCreationStatus(account.getAccountId(),"Sucessfully Created");
		LOGGER.info("Account Created Sucessfully");
		return accountCreationStatus;
	}


	//get customer account
	@Override
	public List<Account> getCustomerAccount(String token, String customerId) {
		List<Account> accountList = accountRepository.findByCustomerId(customerId);
		for (Account acc : accountList) {
			acc.setTransactions(transactionFeign.getTransactionsByAccId(token, acc.getAccountId()));
		}
		return accountList;
	}

	
	// get account by id
	@Override
	public Account getAccount(long accountId) {
		Account account = accountRepository.findByAccountId(accountId);
		if (account == null) {
			throw new AccountNotFoundException("Account Does Not Exist");
		}
		return account;
	}

	// get accountStatement if both dates are provided
	@Override
	public List<String> getAccountStatement(String from, String to) throws WrongDateFormatException, WrongDateProvidedException, ParseException{
		List<Account> accounts = (List<Account>) accountRepository.findAll();
		List<String> statement = new ArrayList<>();
		boolean isValidFrom = dateValidation(from);
		boolean isValidTo = dateValidation(to);
			
		if(!(isValidFrom && isValidTo)) {
			LOGGER.error("Invalid Date Format provided");
			throw new WrongDateFormatException("Invalid Date Format provided");
		}
		Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(to);
		Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(from);
		if(dateTo.compareTo(dateFrom)<0) {
			LOGGER.error("Date : "+ to +"occurs before Date : "+from);
			throw new WrongDateProvidedException("Date : "+ to +"occurs before Date : "+from);
		}
			
		for(Account account: accounts) {
			if(account.getOpeningDate().compareTo(dateFrom)>=0 && account.getOpeningDate().compareTo(dateTo)<=0) {
				statement.add(account.toString());
				LOGGER.debug(account.toString());
			}
		}
		if(statement.size()==0) {
			LOGGER.debug("No Account detail found for given dates");
		}
			
		return statement;
	}
	
	//IF no date is provided
	@Override
	public List<String> getAccountStatement() throws WrongDateFormatException, WrongDateProvidedException, ParseException{	
		LocalDate curr = LocalDate.now();
		LocalDate prev = LocalDate.now().minusDays(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String to = formatter.format(curr);
		String from = formatter.format(prev);
		return getAccountStatement(from, to);
	}
	
	//withdraw of amount 
	@Override
	public Account updateBalance(AccountInput accountInput) {
		LOGGER.info("Account to update" + accountInput.getAccountId());
		Account toUpdateAcc = accountRepository.findByAccountId(accountInput.getAccountId());
		toUpdateAcc.setCurrentBalance(toUpdateAcc.getCurrentBalance() - accountInput.getAmount());
		return accountRepository.save(toUpdateAcc);
	}

	
	//deposit balance
	@Override
	public Account updateDepositBalance(AccountInput accountInput) {
		LOGGER.info("Account update" + accountInput.getAccountId());
		Account toUpdateAcc = accountRepository.findByAccountId(accountInput.getAccountId());
		toUpdateAcc.setCurrentBalance(toUpdateAcc.getCurrentBalance() + accountInput.getAmount());
		return accountRepository.save(toUpdateAcc);
	}

	
	//validate token
	@Override
	public AuthenticationResponse hasPermission(String token) {
		return authFeignClient.tokenValidation(token);
	}
	
	//validity and Employee permissions check

	@Override
	public AuthenticationResponse hasEmployeePermission(String token) {
		AuthenticationResponse validity = authFeignClient.tokenValidation(token);
		if (!authFeignClient.getRole(validity.getUserid()).equalsIgnoreCase("EMPLOYEE")) {
			throw new AccessDeniedException("NOT ALLOWED");
		}
		return validity;
	}

	 
	//validity and customer permissions check
	@Override
	public AuthenticationResponse hasCustomerPermission(String token) {
		AuthenticationResponse validity = authFeignClient.tokenValidation(token);
		if (!authFeignClient.getRole(validity.getUserid()).equalsIgnoreCase("CUSTOMER")) {
			throw new AccessDeniedException("NOT ALLOWED");
		}
		return validity;
	}
	
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();	
		return accounts;
	}
	
	public boolean dateValidation(String from) {
		// TODO Auto-generated method stub
		//REGEX for dd/mm/yyyy
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher((CharSequence)from);
		 return matcher.matches();
	}

}