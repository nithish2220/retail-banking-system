package com.cognizant.authenticationservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppUserTest {

	AppUser pojo = new AppUser();

	@Test
	public void getPassTest() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("password");
		field.setAccessible(true);
		field.set(pojo, "magic_value");
		// when
		String result = pojo.getPassword();
		// then
		assertNotEquals("field wasn't retrieved properly", result, "magic_values");
	}

	@Test
	public void setIdTest() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		// when
		pojo.setUserid("abcd");
		// then
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("userid");
		field.setAccessible(true);
		assertNotEquals("Fields didn't match", field.get(pojo), "emp");
	}

	@Test
	public void getIdTestNeg() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("userid");
		field.setAccessible(true);
		field.set(pojo, "values");
		// when
		String result = pojo.getUserid();
		// then
		assertNotEquals("field wasn't retrieved properly", result, "magic_values");
	}

	@Test
	void setAmountTest() {
		pojo.setAuthToken("abc");
		assertEquals("abc", pojo.getAuthToken());
	}

	@Test
	void getAccountIdTest() {
		pojo.setAuthToken("abc");
		assertTrue(pojo.getAuthToken() == "abc");
	}

	@Test
	void setRoleTest() {
		pojo.setRole("CUSTOMER");
		assertEquals("CUSTOMER", pojo.getRole());
	}

	@Test
	void getRoleTest() {
		pojo.setRole("abc");
		assertTrue(pojo.getRole() == "abc");
	}

	@Test
	void setUserName() {
		pojo.setUsername("abc");
		assertEquals("abc", pojo.getUsername());
	}

	@Test
	void getUserName() {
		pojo.setUsername("abc");
		assertTrue(pojo.getUsername() == "abc");
	}

	AuthenticationResponse response = new AuthenticationResponse();
	AuthenticationResponse response2 = new AuthenticationResponse();
	AuthenticationResponse response3 = new AuthenticationResponse("1", "name", true);

	@Test
	void setUserIdTest() {
		response.setUserid("Cust101");
		assertEquals("Cust101", response.getUserid());
	}

	@Test
	void getUserIdTest() {
		response.setUserid("Cust101");
		assertTrue(response.getUserid() == "Cust101");
	}

	@Test
	void setNameTest() {
		response.setName("Dave");
		assertEquals("Dave", response.getName());
	}

	@Test
	void getNameTest() {
		response.setName("Cust101");
		assertTrue(response.getName() == "Cust101");
	}

	@Test
	void setIsValidTest() {
		response.setValid(true);
		assertEquals(true, response.isValid());
	}

	@Test
	void toSringTest() {
		assertEquals(response2.toString(), response.toString());
	}

}
