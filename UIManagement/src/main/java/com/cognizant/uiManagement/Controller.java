package com.cognizant.uiManagement;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiModel;

@RestController
@ApiModel("Account Management Module")
public class Controller {
	
	public ModelAndView Default(String jspPage) {
		ModelAndView mav= new ModelAndView();
		mav.setViewName(jspPage);
		return mav;
	}
	
	//Employee Index Page 
	@GetMapping("/emp")
	public ModelAndView bankemphome() {
		return Default("empindex");
	}
	
	//Create New Employee 
	@GetMapping("/create-emp-acc")
	public ModelAndView newBankemp() {
		return Default("newemp");
	}
	
	//Employee Creation Success
	@GetMapping("/esuccess")
	public ModelAndView empSuccess() {
		return Default("ecreationsuccess");
	}
	
	//Employee Login
	@GetMapping("/elogin")
	public ModelAndView login() {
		return Default("Elogin");
	}
	
	//Employee Logged inside 
	@GetMapping("/inside")
	public ModelAndView loginSuccess() {
		return Default("EBankMe");
	}
	
	//Employee Creating new Account for Customer
	@GetMapping("/emp-create-new-cust")
	public ModelAndView empNewCust() {
		return Default("empNewCustomer");
	}
	
	//Employee Getting all the details regarding Loans
	@GetMapping("/emp-get-all-loans")
	public ModelAndView getAllLoans() {
		return Default("empGetLoans");
	}
	
	//Employee Getting all Customer Details
	@GetMapping("/emp-get-all-cust")
	public ModelAndView getAllCust() {
		return Default("empGetAllCustomers");
	}
	
	@GetMapping("/cust")
	public ModelAndView custhome() {
		return Default("custindex");
	}

	@GetMapping("/custlogin")
	public ModelAndView custlogin() {
		return Default("custlogin");
	}
	
}
