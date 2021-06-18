package com.cognizant.accountservice.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pulkit Gupta
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreationStatus {

	
	 //AccountCreationStatus for returning response
	@Id
	@Getter
	@Setter
	private long accountId;
	@Getter
	@Setter
	private String message;


}
