package com.cognizant.accountservice.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// for inputing error response
/**
 * @author Pulkit Gupta
 *
 */
@AllArgsConstructor
@NoArgsConstructor
public class AccountErrorResponse {

	@Getter
	@Setter
	private LocalDateTime timestamp;
	@Getter
	@Setter
	private HttpStatus status;
	@Getter
	@Setter
	private String reason;
	@Getter
	@Setter
	private String message;
}
