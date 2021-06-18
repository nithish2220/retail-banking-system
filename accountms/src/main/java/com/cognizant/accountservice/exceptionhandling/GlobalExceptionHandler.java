package com.cognizant.accountservice.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cognizant.accountservice.model.AccountErrorResponse;


/**
 * @author Pulkit Gupta
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	// For access denied
	/**
	 * @param ex
	 * @return ResponseEntity<AccountErrorResponse>
	 */
	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<AccountErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {
		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.CONFLICT ,ex.getMessage() ,"Access Denied" );
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	// For account not found
	/**
	 * @param ae
	 * @return  ResponseEntity<AccountErrorResponse>
	 */
	@ExceptionHandler({ AccountNotFoundException.class })
	public ResponseEntity<AccountErrorResponse> handleAccountNotFoundException(AccountNotFoundException ae) {

		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.NOT_FOUND ,ae.getMessage() , "Account Not Found");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	// if min balance rule is violated
	/**
	 * @param exception
	 * @param request
	 * @return  ResponseEntity<AccountErrorResponse>
	 */
	@ExceptionHandler(MinimumBalanceException.class)
	public ResponseEntity<AccountErrorResponse> nullPointer(MinimumBalanceException exception, WebRequest request) {
		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.NOT_ACCEPTABLE ,exception.getMessage() ,"Access Denied");
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}
	
	//Wrong date format(other than dd/mm/yyyy)
	/**
	 * @param ex
	 * @return  ResponseEntity<AccountErrorResponse>
	 */
	@ExceptionHandler(WrongDateFormatException.class)
	public ResponseEntity<AccountErrorResponse> handleWrongDateFormatException(WrongDateFormatException ex) {
		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.CONFLICT ,ex.getMessage() ,"Wrong Date Format");
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	
	//Wrong date provided(out of Calendar)
	/**
	 * @param ex
	 * @return  ResponseEntity<AccountErrorResponse>
	 */
	@ExceptionHandler(WrongDateProvidedException.class)
	public ResponseEntity<AccountErrorResponse> handleWrongDateProvidedException(WrongDateProvidedException ex) {
		AccountErrorResponse response = new AccountErrorResponse(LocalDateTime.now() ,HttpStatus.NOT_FOUND ,ex.getMessage() ,"Wrong Date Provided");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}