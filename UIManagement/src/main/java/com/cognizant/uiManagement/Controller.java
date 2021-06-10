package com.cognizant.uiManagement;

import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiModel;

@org.springframework.stereotype.Controller
@ApiModel("Account Management Module")
public class Controller {
	
	
	//Employee Index Page 
	@GetMapping("/emp")
	public String bankemphome() {
		return "empindex";
	}
	
	//Create New Employee 
	@GetMapping("/create-emp-acc")
	public String newBankemp() {
		return "newemp";
	}
	
	//Employee Creation Success
	@GetMapping("/esuccess")
	public String empSuccess() {
		return "ecreationsuccess";
	}
	
	//Employee Login
	@GetMapping("/elogin")
	public String login() {
		return "Elogin";
	}
	
	//Employee Logged inside 
	@GetMapping("/inside")
	public String loginSuccess() {
		return "EBankMe";
	}
	
	//Employee Creating new Account for Customer
	@GetMapping("/emp-create-new-cust")
	public String empNewCust() {
		return "empNewCustomer";
	}
	
	//Employee Getting all the details regarding Loans
	@GetMapping("/emp-get-all-loans")
	public String getAllLoans() {
		return "empGetLoans";
	}
	
	//Employee Getting all Customer Details
	@GetMapping("/emp-get-all-cust")
	public String getAllCust() {
		return "empGetAllCustomers";
	}
	
	@GetMapping("/cust")
	public String custhome() {
		return "custindex";
	}

	@GetMapping("/custlogin")
	public String custlogin() {
		return "custlogin";
	}
	
}
