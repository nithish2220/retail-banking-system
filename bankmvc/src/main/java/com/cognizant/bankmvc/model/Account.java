package com.cognizant.bankmvc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author S Nithish Kumar
 *
 */
@Data
@NoArgsConstructor
public class Account {
	
	private long accountId;

	private String customerId;

	//private String accountNumber;

	private double currentBalance;

	private String accountType;
	
	private Date openingDate;

	private String ownerName;

	private transient List<Transaction> transactions = new ArrayList<Transaction>();


}