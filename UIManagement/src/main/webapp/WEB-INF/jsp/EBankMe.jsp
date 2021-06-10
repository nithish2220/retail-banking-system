<%@ include file="common/header.jspf"%> 
<%@ include file="common/footer.jspf"%>

<!-- Header -->
<div class="sticky-top bg-dark d-flex align-content-center">
	<a href="/inside" class="active nav-link text-white"><h1>Peoples' Bank</h1></a>
	<ul class="align-content-center container nav nav-pills justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="/emp">Logout
				</a></li>
	</ul>
</div>


<!-- Body -->
<h2 class="container text-center">Welcome Back!!</h2>

<!-- Div for all cards  -->


<div class="container card-group">
	<div class="row ps-3 my-3">
		<div class="col-sm-6">
			<div class="card">
				 <img class="card-img-top" src="images/create-customer.jpg" alt="Card image cap" height="250">
				<div class="card-body">
					<h5 class="card-title">Create New Account/Customer</h5>
					<p class="card-text">Click the Below link to create a New Account.</p>
					<a href="/emp-create-new-cust" class="btn btn-primary">Create Account/Customer</a>
				</div>
				<div class="card-footer text-muted">Open a New Account</div>
			</div>
		</div>
		
		<div class="col-sm-6">
			<div class="card">
				 <img class="card-img-top" src="images/ApproveLoan.png" alt="Card image cap"  height="250">
				<div class="card-body">
					<h5 class="card-title">Loans'</h5>
					<p class="card-text">Go to Loans section and view the Loans requests by customers.</p>
					<a href="/emp-get-all-loans" class="btn btn-primary">Loans Section</a>
				</div>
				<div class="card-footer text-muted">Approve or Reject Loans</div>
			</div>
		</div>
		
		
		
	</div>
</div>

<br>
<br>


<div class="container card text-center">
	<img class="card-img-top" src="images/getAllCustomers.png" alt="Card image cap" height="250">
  <div class="card-body">
    <h5 class="card-title">Get All the Customer Details</h5>
    <p class="card-text">Click the below link to view all customer accounts.</p>
    <a href="/emp-get-all-cust" class="btn btn-primary">Get Customer Accounts Details</a>
  </div>
  <div class="card-footer text-muted">
    Get All the Customer Details
  </div>
</div>


<br>
<br>
<br>
<br>

</body>
