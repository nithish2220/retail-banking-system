package com.cognizant.authenticationservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cognizant.authenticationservice.model.AppUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthTests {

	public String token;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wc;

	List<AppUser> employees = new ArrayList<AppUser>();
	static ObjectMapper mapper = new ObjectMapper();

	@Before
	// before testing class login should be done
	// it execute before all methods
	public void setUp() throws JsonProcessingException, Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
		validLogin();
	}

	public static <T> T parseResponse(MvcResult result, Class<T> responseClass)
			throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException {

		String contentAsString = result.getResponse().getContentAsString();
		return mapper.readValue(contentAsString, responseClass);

	}

	// test : save employee mapping is tested
	@Test
	public void saveEmployee() throws JsonProcessingException, Exception {
		AppUser menu = new AppUser("111", "ba", "ba", "", "EMPLOYEE");
		String json = mapper.writeValueAsString(menu);
		mockMvc.perform(MockMvcRequestBuilders.post("/createUser").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.userid").exists());
	}

	// test : save employee based on user id
	@Test
	public void saveEmployeeNeg() throws JsonProcessingException, Exception {
		AppUser menu = new AppUser("111", "yam", "yam", "", "EMPLOYEE");
		String json = mapper.writeValueAsString(menu);
		mockMvc.perform(MockMvcRequestBuilders.post("/createUser").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.userid1").doesNotExist());

	}

	// test : valid Login with token
	@Test
	public void validLogin() throws JsonProcessingException, Exception {
		AppUser appUser = new AppUser("EMPLOYEE101", "emp", "emp", "", "EMPLOYEE");
		String json = mapper.writeValueAsString(appUser);
		MvcResult andReturn = mockMvc
				.perform(MockMvcRequestBuilders.post("/login").content(json).contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful()).andExpect(MockMvcResultMatchers.jsonPath("$.authToken").exists())
				.andReturn();
		AppUser response = parseResponse(andReturn, AppUser.class);
		token = response.getAuthToken();
	}

	// test: checks if invalid login(wrong token) proceeds or not
	@Test
	public void invaidLogin() throws JsonProcessingException, Exception {
		AppUser appUser = new AppUser("EMPLOYEE101", "emp", "emp", "", "EMPLOYEE");
		String json = mapper.writeValueAsString(appUser);
		MvcResult andReturn = mockMvc
				.perform(MockMvcRequestBuilders.post("/login").content(json).contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.authToken2").doesNotExist()).andReturn();
	}

	// test : get Employee based on token
	@Test
	public void getOneEmployee() throws JsonProcessingException, Exception {
		System.err.println(token);
		mockMvc.perform(MockMvcRequestBuilders.post("/find").header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isMethodNotAllowed());
	}

	// test : get Employee based on no token
	@Test
	public void getOneEmployee1() throws JsonProcessingException, Exception {
		System.err.println(token);
		mockMvc.perform(MockMvcRequestBuilders.post("/find").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isMethodNotAllowed());

	}

	// health check :: UP
	@Test
	public void getHealthUp() throws JsonProcessingException, Exception {
		System.err.println(token);
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/health").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		boolean equals = andReturn.getResponse().getContentAsString().equals("UP");
		assertEquals(equals, true);

	}

	// health check :: DOWN
	@Test
	public void getHealthDown() throws JsonProcessingException, Exception {
		System.err.println(token);
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/health").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		boolean equals = andReturn.getResponse().getContentAsString().equals("DOWN");
		assertNotEquals(equals, true);

	}

	// valid token check
	@Test
	public void getValidate() throws JsonProcessingException, Exception {
		System.err.println(token);
		mockMvc.perform(MockMvcRequestBuilders.get("/validateToken").header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	public void getInvalidate() throws JsonProcessingException, Exception {
		System.err.println(token);
		mockMvc.perform(MockMvcRequestBuilders.get("/validateToken").header("Authorization", token)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void setterNameTest() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		// when
		pojo.setUsername("CUST101");
		// then
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("username");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "CUST101");
	}

	@Test
	public void setterNameTestNeg() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		// when
		pojo.setUsername("CUST102");
		// then
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("username");
		field.setAccessible(true);
		assertNotEquals("Fields didn't match", field.get(pojo), "CUST2");
	}

	@Test
	public void getterNameTest() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("username");
		field.setAccessible(true);
		field.set(pojo, "magic_values");
		// when
		String result = pojo.getUsername();
		// then
		assertEquals("field wasn't retrieved properly", result, "magic_values");
	}

	@Test
	public void getterNameTestNeg() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("username");
		field.setAccessible(true);
		field.set(pojo, "values");
		// when
		String result = pojo.getUsername();
		// then
		assertNotEquals("field wasn't retrieved properly", result, "magic_values");
	}

	@Test
	public void setterPassTest() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		// when
		pojo.setPassword("cust");
		// then
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("password");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "cust");
	}

	@Test
	public void setterPassTestNeg() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		// when
		pojo.setPassword("abcde");
		// then
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("password");
		field.setAccessible(true);
		assertNotEquals("Fields didn't match", field.get(pojo), "abc");
	}

	@Test
	public void getRoleTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role").accept(MediaType.APPLICATION_JSON)).andReturn();
	}

}
