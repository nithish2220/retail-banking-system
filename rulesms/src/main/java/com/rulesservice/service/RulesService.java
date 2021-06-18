package com.rulesservice.service;

import com.rulesservice.model.AuthenticationResponse;
import com.rulesservice.model.RulesInput;
import com.rulesservice.model.ServiceResponse;

/**
 * @author Saaketh
 *
 */
public interface RulesService {
	
	/**
	 * @param account
	 * @return boolean
	 */
	public boolean evaluate(RulesInput account);
	
	/**
	 * @param token
	 * @return AuthenticationResponse
	 */
	public AuthenticationResponse hasPermission(String token);
	
	/**
	 * @param account
	 * @return ServiceResponse
	 */
	public ServiceResponse serviceCharges(RulesInput account);
	
}
