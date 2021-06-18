package com.cognizant.authenticationservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Isha Rahal
 *
 */
@Service
public class JwtUtil {

	private String secretkey = "${jwt.secret}";

	/**
	 * @param token
	 * @return extractClaim(token, Claims::getSubject)
	 */
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * @param <T>
	 * @param token
	 * @param claimsResolver
	 * @return claimsResolver.apply(claims)
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * @param token
	 * @return jwt claims
	 */
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
	}

	/**
	 * @param userDetails
	 * @return createToken(claims, userDetails.getUsername())
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	/**
	 * @param claims
	 * @param subject
	 * @return jwt token
	 */
	private String createToken(Map<String, Object> claims, String subject) {
		return  Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*10))
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
	}
	
	/**
	 * @param token
	 * @return boolean
	 */
	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}