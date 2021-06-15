package com.cognizant.accountservice.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sasan
 *
 */
@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	// Account model
	@Id
	@NotNull(message = "Enter Account number")
	@Getter
	@Setter
	private long accountId;
	
	@NotBlank(message = "Enter customerId")
	@Getter
	@Setter
	private String customerId;

	@NotNull(message = "Enter currentBalance")
	@Getter
	@Setter
	private double currentBalance;

	@Getter
	@Setter
	@NotBlank(message = "Enter accountType")
	private String accountType;

	@Getter
	@Setter
	private Date openingDate;
	

	
	@Getter
	@Setter
	@Column(length = 20)
	@NotBlank(message = "Enter ownerName")
	private String ownerName;

	//one customer has multiple account
	//one account has multiple transactions
	// mapping of account and transaction is done by account object in transaction model
	//@OneToMany(mappedBy="account")
	//private List<Transaction> transactions;
	
	// mapping of account and customer is done by customer object
	//@ManyToOne
	//private Customer customer;
	//not mapped to any database column
	@Getter
	@Setter
	@Transient
	private List<Transaction> transactions;


}