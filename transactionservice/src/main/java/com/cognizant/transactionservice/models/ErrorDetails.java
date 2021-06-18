package com.cognizant.transactionservice.models;

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
public class ErrorDetails {

	private String message;
	private String details;
}
