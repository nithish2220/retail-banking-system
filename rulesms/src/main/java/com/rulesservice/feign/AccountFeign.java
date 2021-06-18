package com.rulesservice.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.rulesservice.model.Account;
import com.rulesservice.model.AccountInput;

/**
 * @author Saaketh
 *
 */
@FeignClient(name = "account-ms", url = "${feign.url-account-service}")
public interface AccountFeign {

	/**
	 * @param token
	 * @param accInput
	 * @return ResponseEntity<Account>
	 */
	@PostMapping("/servicecharge")
	public ResponseEntity<Account> servicecharge(@RequestHeader("Authorization") String token,
			@RequestBody AccountInput accInput);

	/**
	 * @param token
	 * @return ResponseEntity<List<Account>>
	 */
	@GetMapping("/find")
	public ResponseEntity<List<Account>> getAllacc(@RequestHeader("Authorization") String token);
	

}
