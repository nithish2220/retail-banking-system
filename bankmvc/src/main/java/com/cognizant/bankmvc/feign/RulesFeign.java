package com.cognizant.bankmvc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author S Nithish Kumar
 *
 */
@FeignClient(name = "rules", url = "${feign.url-rules-service}")
public interface RulesFeign {

	/**
	 * @param token
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/serviceCharges")
	public ResponseEntity<?> serviceCharges(@RequestHeader("Authorization") String token);
}
