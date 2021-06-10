<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>

<!-- Header -->
<div class="sticky-top bg-dark d-flex align-content-center">
	<a href="/emp" class="active nav-link text-white"><h1>Peoples' Bank</h1></a>
</div>

<!-- Body div 1 for Login Employee -->
<div class="center">
<form class="container" action="/inside" method="get">
	<div class="form-group container">
		<label for="exampleInputEmail1">Email address</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			aria-describedby="emailHelp" placeholder="Enter email" required> <small
			id="emailHelp" class="form-text text-muted">We'll never share
			your email with anyone else.</small>
	</div>
	<div class="container form-group">
		<label for="exampleInputPassword1">Password</label> <input
			type="password" class="form-control" id="exampleInputPassword1"
			placeholder="Password" required>
	</div>
	<br>
	<br>
	<button type="submit" class="btn btn-primary">Submit</button>
	<br>
</form>
</div>
</body>