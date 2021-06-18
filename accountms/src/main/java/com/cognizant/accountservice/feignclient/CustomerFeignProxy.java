package com.cognizant.accountservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.accountservice.model.CustomerEntity;


/**
 * @author Pulkit Gupta
 *
 */
@FeignClient(name = "customer", url = "${feign.url-customer-service}")
public interface CustomerFeignProxy {

	//Getting customer
	/**
	 * @param id
	 * @return CustomerEntity
	 */
	@GetMapping("/getCustomerDetails/{id}")
	public CustomerEntity getCustomerDetails(@PathVariable(name = "id") String id);

}
