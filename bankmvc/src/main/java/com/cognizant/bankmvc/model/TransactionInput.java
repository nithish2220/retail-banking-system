package com.cognizant.bankmvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author S Nithish Kumar
 *
 */
@Data
@NoArgsConstructor
public class TransactionInput {

	private AccountInput sourceAccount;
	private AccountInput targetAccount;
	private double amount;
	private String reference;

	
}