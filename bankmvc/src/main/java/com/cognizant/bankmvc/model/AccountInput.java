package com.cognizant.bankmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author S Nithish Kumar
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInput {
	private long accountId;
	private double amount;

	
}