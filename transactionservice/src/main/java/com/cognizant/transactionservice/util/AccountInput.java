package com.cognizant.transactionservice.util;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Dhananjay Batra
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInput {

	@NotNull(message = "Account number is mandatory")
	private long accountId;
	@NotNull(message = "Amount is mandatory")
	private double amount;

	
} 