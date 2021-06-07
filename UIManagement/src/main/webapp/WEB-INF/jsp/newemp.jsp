<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>

<!-- Header -->
<div class="sticky-top bg-dark d-flex align-content-center">
	<a href="/emp" class="active nav-link text-white"><h1>Peoples' Bank</h1> <i><h5>-Let's
				make the change together...</h5></i></a>
	<ul class="align-content-center container nav nav-pills justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="/elogin">Login
				to my Account</a></li>
		<li class="nav-item"><a class="nav-link" href="/create-emp-acc">Create
				an Account</a></li>
	</ul>
</div>

<!-- New Employee Registration Page -->
<!-- Pills navs -->
<!-- Pills content -->
<div class="tab-content">
	<div class="tab-pane fade show active" id="pills-login" role="tabpanel"
		aria-labelledby="tab-login"></div>
</div>


<form class="container" method="get" action="/esuccess">
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4">Email</label> <input type="email"
				class="form-control" id="inputEmail4" name="inputEmail4"
				placeholder="Email" required>
		</div>

		<div class="form-group col-md-6">
			<label for="inputPassword4">Password</label> <input type="password"
				class="form-control" id="inputPassword4" placeholder="Password"
				id="psw" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
				title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				required>
		</div>


		<div id="message">
			<h3>Password must contain the following:</h3>
			<p id="letter" class="invalid">
			<ul class="list-inline">
				<li class="list-inline-item"><b>* lowercase</b> letter</li>
				<li class="list-inline-item"><b>* capital (uppercase)</b>
					letter</li>
				<li class="list-inline-item"><b>* number</b></li>
				<li class="list-inline-item"><b>* Minimum 8 </b>characters</li>
			</ul>
			</p>
		</div>
	</div>
	<div class="form-group">
		<label for="inputAddress">Address</label> <input type="text"
			class="form-control" id="inputAddress" placeholder="1234 Main St" required>
	</div>
	<div class="form-group">
		<label for="inputAddress2">Address 2</label> <input type="text"
			class="form-control" id="inputAddress2"
			placeholder="Apartment, studio, or floor" required>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputCity">City</label> <input type="text"
				class="form-control" id="inputCity" required>
		</div>
		<div class="form-group col-md-4">
			<label for="inputState">State</label> <select id="inputState"
				class="form-control" required>
				<option selected>Choose..</option>
				<option value="Andhra Pradesh">Andhra Pradesh</option>
				<option value="Andaman and Nicobar Islands">Andaman and
					Nicobar Islands</option>
				<option value="Arunachal Pradesh">Arunachal Pradesh</option>
				<option value="Assam">Assam</option>
				<option value="Bihar">Bihar</option>
				<option value="Chandigarh">Chandigarh</option>
				<option value="Chhattisgarh">Chhattisgarh</option>
				<option value="Dadar and Nagar Haveli">Dadar and Nagar
					Haveli</option>
				<option value="Daman and Diu">Daman and Diu</option>
				<option value="Delhi">Delhi</option>
				<option value="Lakshadweep">Lakshadweep</option>
				<option value="Puducherry">Puducherry</option>
				<option value="Goa">Goa</option>
				<option value="Gujarat">Gujarat</option>
				<option value="Haryana">Haryana</option>
				<option value="Himachal Pradesh">Himachal Pradesh</option>
				<option value="Jammu and Kashmir">Jammu and Kashmir</option>
				<option value="Jharkhand">Jharkhand</option>
				<option value="Karnataka">Karnataka</option>
				<option value="Kerala">Kerala</option>
				<option value="Madhya Pradesh">Madhya Pradesh</option>
				<option value="Maharashtra">Maharashtra</option>
				<option value="Manipur">Manipur</option>
				<option value="Meghalaya">Meghalaya</option>
				<option value="Mizoram">Mizoram</option>
				<option value="Nagaland">Nagaland</option>
				<option value="Odisha">Odisha</option>
				<option value="Punjab">Punjab</option>
				<option value="Rajasthan">Rajasthan</option>
				<option value="Sikkim">Sikkim</option>
				<option value="Tamil Nadu">Tamil Nadu</option>
				<option value="Telangana">Telangana</option>
				<option value="Tripura">Tripura</option>
				<option value="Uttar Pradesh">Uttar Pradesh</option>
				<option value="Uttarakhand">Uttarakhand</option>
				<option value="West Bengal">West Bengal</option>
			</select>
		</div>
		<div class="form-group col-md-2">
			<label for="inputZip">Zip</label> <input type="text"
				class="form-control" id="inputZip" required>
		</div>
	</div>
	<div class="form-group">
		<div class="form-check">
			<input class="form-check-input" type="checkbox" id="gridCheck" required>
			<label class="form-check-label" for="gridCheck" > By Clicking
				I am accepting all Terms and Conditions </label>
		</div>
	</div>
	<button type="submit" class="btn btn-primary">Sign in</button>
</form>


<script>
var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>
</body>
