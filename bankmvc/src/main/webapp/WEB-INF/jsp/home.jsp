<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<!-- <link href="/css/home.css" rel="stylesheet">  -->
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.fa {
	padding: 10px;
	font-size: 30px;
	width: 50px;
	text-align: center;
	text-decoration: none;
	margin: 5px 2px;
}

.fa:hover {
	opacity: 0.7;
}

.fa-facebook {
	background: #3B5998;
	color: white;
}

.fa-twitter {
	background: #55ACEE;
	color: white;
}

.fa-linkedin {
	background: #007bb5;
	color: white;
}

.fa-youtube {
	background: #bb0000;
	color: white;
}

.fa-instagram {
	background: #125688;
	color: white;
}
</style>

<title>Home Page</title>

</head>

<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>

<body>

    <!--  <div id="login-box" align="center"> 
         <h1 >ABC Bank</h1>
           <form action="/employeelogin" method="get">
          <button class="custom-btn btn-2">Employee Login</a></button>
           </form>
           <form action="/customerlogin" method="get">
             <button class="custom-btn btn-2">Customer Login</a></button>
           </form>
         
    </div>
</body>
 -->
 
 <div class="sticky-top bg-dark d-flex align-content-center">
	<a href="/" class="active nav-link text-white"><h1><i>Peoples' Bank</i></h1></a>
	<ul class="align-content-center container nav nav-pills justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="/employeelogin">Employee Login
				</a></li>
		<li class="nav-item"><a class="nav-link" href="/customerlogin">Customer Login</a></li>
	</ul>
</div>


<br>
<br>
<!-- body div container 1 -->
<div class="container" style="object-fit: cover;">
	<h4 class="text-centre">Welcome to Peoples' Bank</h4>

	<p class="container">Its' simpler, smarter & more intuitive than
		ever.</p>
</div>


<div class="container text-white" style="object-fit: cover;">
	<div class="jumbotron bg-cover"
		style="background-image: url(images/feeedback.jpg)">
		<h1 class="display-4">Presenting the all new Peoples' Banking</h1>
		<p class="lead">You can also login through the below "Login
			Button".</p>
		<hr class="my-4">
		<p></p>
		<p class="lead">
			<a class="btn btn-primary btn-lg" href="/customerlogin" role="button">Customer Login</a>
		</p>
	</div>
</div>

<br>
<br>


<!-- Body div container 2 -->
<div class="container card-group ">
	<div class="card">

		<div class="card-body p-5 my-10">
			<h5 class="card-title">Locate Us</h5>
			<p class="card-text">You are never too far away from quick,
				efficient banking services. Locate your nearest branch or an ATM.</p>

		</div>
	</div>
	<div class="card">

		<div class="card-body p-5 my-10">
			<h5 class="card-title">Call Us</h5>
			<p class="card-text">In case you wish to speak to our phone
				banking officer for urgent resolution.</p>
		</div>
	</div>
	<div class="card">

		<div class="card-body p-5 my-10">
			<h5 class="card-title">Write to Us</h5>
			<p class="card-text">Be it an enquiry, feedback or a simple
				suggestion, write to us & we'll get back to you.</p>
		</div>
	</div>
</div>

<br>
<br>

<!-- Body div container 3 "About Us"-->
<div class="component text-white bg-secondary text-center" style="background-color='#e6ffff';">
	<div class="component container">
		<br>
		<h4>About Us</h4>
		<div class="container">
			<p class="row">Peoples' Bank Limited is an Indian private sector
				bank headquartered in Mumbai, Maharashtra, India. It offers banking
				products and financial services for corporate and retail customers
				in the areas of personal finance, investment banking, life
				insurance, and wealth management. As of February 2021, it is the
				third largest Indian private sector bank by market capitalization,
				with 1600 branches & 2519 ATMs.</p>
			<p class="row">Peoples Bank was formed in September of 2000,
				however, our story begins long before that time. Most of our
				employees and directors started working together in the early 1980s,
				for Grant County Bank. Throughout the 80s' and 90s', the name on the
				outside of the building changed several times, but for the most
				part, the people inside the bank stayed the same. The founders of
				Peoples Bank came to realize that the name on the building didnt'
				make the bank; rather, the employees and customers who passed
				through its doors were its heart and soul. With this in mind,
				Peoples Bank was born. Since then, its' been our mission to be the
				bank where people come first. Nothing is more important than our
				customers and it is our privilege to serve your banking needs with
				care and excellence in mind. Today Peoples Bank is going strong,
				continuously evolving to the needs of its customers while staying
				rooted in its core principles, including friendly customer service
				and personalized banking solutions.</p>
		</div>


		<div class="row">
			<div class="col">
				<h4 class="container">Connect to Us</h4>
			</div>
		</div>
	
	
		<a href="https://www.facebook.com/Cognizant" class="fa fa-facebook"></a>
		<a href="https://twitter.com/cognizant" class="fa fa-twitter"></a> <a
			href="https://www.youtube.com/channel/UCXscwCVOk653HlNY9wwES_w"
			class="fa fa-youtube"></a> <a
			href="https://www.linkedin.com/company/cognizant"
			class="fa fa-linkedin"></a>

	</div>
	<br> <br><br>
</div>




</body>
</html>