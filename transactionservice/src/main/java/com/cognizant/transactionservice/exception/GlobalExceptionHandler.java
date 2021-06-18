package com.cognizant.transactionservice.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cognizant.transactionservice.models.TransactionErrorResponse;

/**
 * @author Dhananjay Batra
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * @param exception
	 * @param request
	 * @return ResponseEntity<TransactionErrorResponse>
	 */
	@ExceptionHandler(MinimumBalanceException.class)
	public ResponseEntity<TransactionErrorResponse> nullPointer(MinimumBalanceException exception, WebRequest request) {
		TransactionErrorResponse response = new TransactionErrorResponse(LocalDateTime.now() ,HttpStatus.NOT_ACCEPTABLE ,exception.getMessage() ,"Access Denied");
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}

}