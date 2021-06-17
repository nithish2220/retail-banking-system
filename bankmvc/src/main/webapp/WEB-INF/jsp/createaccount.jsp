<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="register.css" rel="stylesheet">
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<title>Create Customer</title>
<style>
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}
    input[type="text"],
input[type="number"],
select[type="text"]
{
  display: block;
  box-sizing: border-box;
  margin-bottom: 20px;
  padding: 4px;
  width: 220px;
  height: 32px;
  border: none;
  border-bottom: 1px solid #AAA;
  font-family: 'Roboto', sans-serif;
  font-weight: 400;
  font-size: 15px;
  transition: 0.2s ease;
}

input[type="text"]:focus,
input[type="number"]:focus {
  border-bottom: 2px solid #16a085;
  color: #16a085;
  transition: 0.2s ease;
}

input[type="submit"]{
  margin-top: 28px;
  width: 120px;
  height: 32px;
  background: #16a085;
  border: none;
  border-radius: 2px;
  color: #FFF;
  font-family: 'Roboto', sans-serif;
  font-weight: 500;
  text-transform: uppercase;
  transition: 0.1s ease;
  cursor: pointer;
}

input[type="submit"]:hover,
input[type="submit"]:focus {
  opacity: 0.8;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
}

input[type="submit"]:active {
  opacity: 1;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
}

    </style>
</head>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<body class="container bg-secondary text-white" >

	<%
		response.setHeader("cache-control", "no-cache , no-store , must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session.getAttribute("userId") == null || session.getAttribute("token") == null) {
	%>
	<c:redirect url="/403" />
	<%
		}
	%>
	
	
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header ">
      <a class="navbar-brand text-white" href="/dashboard"><h2>Peoples' Bank</h2></a>
    </div>
    <ul class="nav active nav-link ">
      <li><a class="text-white nav-link btn btn-info" href="/dashboard">Home</a></li>
  
    </ul>
  </div>
</nav>

	<div align="center">	
		<div id="login-box">

			<h1 class="signup"><i>Customer Account Creation</i></h1>
			<br>
			<form:form action="/finishedAccountCreation" method="post"
				modelAttribute="account">

				CUSTOMER ID: <form:input type="text" path="customerId" name="customerId"
					value="${customerId}" readonly="true" />
				<!--  ACCOUNT ID: <form:input type="number" path="accountId" name="accountId"
					value="${account.accountId}" autocomplete="off" />-->
				OPENING AMOUNT: <form:input type="number" path="currentBalance" min="0"
					name="currentBalance" placeholder="Amount" value="0" autocomplete="off" />
				ACCOUNT TYPE: <form:select type="text" path="accountType" placeholder="Account Type" name="accountType" autocomplete="off">
					<form:option value="Savings"></form:option>
					<form:option value="Current"></form:option>
				</form:select>
				
				<form:input path="openingDate" name="openingDate" id="openingDate" type="hidden" class="form-control" value="<%=(new Date()).toLocaleString() %>"/>
				
					
				OWNER NAME: <form:input type="text" path="ownerName" name="ownerName"
					placeholder="OwnerName" autocomplete="off" />
				
				<input type="checkbox" required> Accepting Terms and Conditions
				<br>
				<input type="submit" name="signup_submit" value="Create" />

			</form:form>
			<br>
			
			<p>
			 
			<a class="active btn btn-warning" href="/dashboard?custmsg=Customer Created">Go Back</a> and Create Account Later....!!</p>
		</div>


	</div>
</body>
</html>
