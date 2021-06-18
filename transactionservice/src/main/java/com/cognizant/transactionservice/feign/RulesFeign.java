package com.cognizant.transactionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.transactionservice.exception.MinimumBalanceException;
import com.cognizant.transactionservice.models.RulesInput;

/**
 * @author Dhananjay Batra
 *
 */
@FeignClient(name = "rules-ms", url = "${feign.url-rule-service}")
public interface RulesFeign {
	
	/**
	 * @param account
	 * @return ResponseEntity<?>
	 * @throws MinimumBalanceException
	 */
	@PostMapping("/evaluateMinBal")
	public ResponseEntity<?> evaluate(@RequestBody RulesInput account)throws MinimumBalanceException ;
	
	/**
	 * @param token
	 * @param account
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/serviceCharges")
	public ResponseEntity<?> serviceCharges(@RequestHeader("Authorization") String token,@RequestBody RulesInput account);
	

}
