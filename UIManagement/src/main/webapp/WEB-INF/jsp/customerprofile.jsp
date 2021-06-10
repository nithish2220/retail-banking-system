<%@ include file="common/header.jspf"%> 
<%@ include file="common/footer.jspf"%>

<!-- Header -->
<div class="sticky-top bg-dark d-flex align-content-center">
	<a href="/inside" class="active nav-link text-white"><h1>Peoples' Bank</h1></a>
	<ul class="align-content-center container nav nav-pills justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="/cust">Logout
				</a></li>
	</ul>
</div>

<div class="container">
	<h3><i>Viewing Customer Profile!</i></h3>
</div>
<br>
<br>

<div class="container text-centre">
	<table border="2" cellpadding="5"  class="container">
		<tr>
			<th>CUSTOMER ID</th>
			<th>CUSTOMER NAME</th>
			<th>DOB</th>
			<th>PAN</th>
			<th>ADDRESS</th>
			<th>ACCOUNTS</th>
		</tr>
	</table>
	<br>
	<br>
	<table border="1" cellpadding="5">
		<tr>
			<th>ACCOUNT ID</th>
			<th>CURRENT BALANCE</th>
			<th>ACCOUNT TYPE</th>
			<th>OWNER NAME</th>
		</tr>
	</table>
</div>

</body>
