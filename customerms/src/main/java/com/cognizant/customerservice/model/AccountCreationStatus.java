package com.cognizant.customerservice.model;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sri Durga
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountCreationStatus {

	@Id
	long accountId;
	String message;
	

	
}
