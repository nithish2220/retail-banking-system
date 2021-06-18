package com.cognizant.transactionservice.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.transactionservice.models.Account;

/**
 * @author Dhananjay Batra
 *
 */
@FeignClient(name = "account-ms", url = "${feign.url-account-service}")
public interface AccountFeign {
	
	/**
	 * @param token
	 * @param accountId
	 * @return Account
	 */
	@GetMapping("/getAccount/{accountId}")
	public Account getAccount(@RequestHeader("Authorization") String token , @PathVariable(name="accountId") long accountId);

	/**
	 * @param sourceAccount
	 * @return boolean
	 */
	@PostMapping("/updateAccount")
	public boolean updateAccount(Account sourceAccount);

	/**
	 * @param accId
	 * @param currentBalance
	 * @return boolean
	 */
	@GetMapping("/updateAccountById/{id}") 
	public boolean updateAccountById(@PathVariable("id")long accId,double currentBalance);
	

}
