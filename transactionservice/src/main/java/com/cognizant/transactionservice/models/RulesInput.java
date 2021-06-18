package com.cognizant.transactionservice.models;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Dhananjay Batra
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RulesInput {	

	@NotNull
	private long accountId;
	@NotNull
	private double currentBalance;
	@NotNull
	private double amount;

}
