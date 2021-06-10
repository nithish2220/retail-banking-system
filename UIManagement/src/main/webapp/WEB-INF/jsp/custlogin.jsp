<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="sticky-top bg-dark d-flex align-content-center">
	<a href="/emp" class="active nav-link text-white"><h1>Peoples' Bank</h1> </a>
</div>
<form class="container" action="/customerinside" method="get">
	<div class="form-group container">
		<label for="exampleInputEmail1">Email address</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			aria-describedby="emailHelp" placeholder="Enter email"> <small
			id="emailHelp" class="form-text text-muted">We'll never share
			your email with anyone else.</small>
	</div>
	<div class="container form-group">
		<label for="exampleInputPassword1">Password</label> <input
			type="password" class="form-control" id="exampleInputPassword1"
			placeholder="Password">
	</div>
	<br>
	<br>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>