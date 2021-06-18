<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/register.css" rel="stylesheet">
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Create Customer</title>
<style>
#message
{
	color : red; 
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}
</style>
</head>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>

<body class="bg-secondary">
<div align="center">
		
		
	<%
		
		if (session.getAttribute("token") == null) {
	%>
	<c:redirect url="/403" />
	<%
		}
	%>

          <nav class="navbar navbar-inverse">
  <div class="container-fluid ">
    <div class="navbar-header ">
      <a class="navbar-brand text-white" href="/dashboard"><h2><i>Peoples' Bank</i></h2></a>
    </div>
    <ul class="nav active nav-link ">
      <li><a class="text-white nav-link btn btn-info" href="/dashboard">Home</a></li>
  
    </ul>
  </div>
</nav>

	<div class="container" id="login-box">

			<div class="container justify-content">
			
			
				<table class="container">
					<form:form action="/finishedCustomerCreation" method="post"
						modelAttribute="customer">
						<thead>
							<h2>
								<i>Customer Creation!!</i>
							</h2>
						</thead>
						<tr>
							<th>Enter Customer ID</th>
							<td></td>
							<td><form:input type="text" path="userid" name="Id"
									placeholder="Enter Id" autocomplete="off" required="required"/></td>
						</tr>
						<tr>
							<th>Enter Username</th>
							<td></td>
							<td><form:input type="text" path="username" name="username"
									placeholder="Username" autocomplete="off" required="required"/></td>
						</tr>
						<tr>
							<th>Enter Password</th>
							<td></td>
							<td><form:input type="password" path="password"
									name="password" placeholder="Password" required="required"/></td>
						</tr>
						<tr>
							<th>Enter Date Of Birth</th>
							<td></td>
							<td><form:input type="date" id="date" path="dateOfBirth"
									name="dob" placeholder="Date of Birth" required="required"/></td>
						</tr>
						<tr>
							<th>Enter PAN Number</th>
							<td></td>
							<td><form:input type="text" path="pan" name="pan"
									placeholder="Pan Number" autocomplete="off" maxlength="10" required="required"/></td>
						</tr>
						<tr>
							<th>Enter Present Address</th>
							<td></td>
							<td><form:input type="text" path="address" name="address"
									placeholder="address" autocomplete="off" required="required" /></td>
						</tr>
					
					<tr>
					<th>
						<input type="checkbox" required/> I Accept all Terms and Conditions*
					</th>
					</tr>
					<tr>
						<th><input type="submit" name="signup_submit" value="Create" /></th>
					</tr>
			</form:form>
					<p id="message">${msg }</p>
				</table>
			</div>
			
		</div>
        

</div>
</body>
</html>