package com.cognizant.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Isha Rahal
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appuser")
public class AppUser {
	
	@Id
	@Column(name = "userid", length = 20)
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	private String userid;
	
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	@Column(name = "username", length = 20)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	private String authToken;
	
	private String role;
}
