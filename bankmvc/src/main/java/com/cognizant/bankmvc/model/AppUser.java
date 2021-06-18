package com.cognizant.bankmvc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author S Nithish Kumar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
	
	private String userid;
	
	private String username;
	
	private String password;
	
	private String authToken;
	
	private String role;
}