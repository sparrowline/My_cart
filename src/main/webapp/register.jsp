<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<%@ include file="components/common_css_js.jsp"%>

</head>
<body>
	<%@include file="components/navbar.jsp"%>

<div class="container-fluid">
<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
			<div class="card">
	<%@include file="components/message.jsp"  %>
				<div class="card-body px-5">

					<form action="registermykart" method="get">

						<h2 class="text-center my-3">Sign Up here !!</h2>
						<div class="form-group">
							<label for="Name">User Name</label> <input type="text"
								class="form-control" id="Name" aria-describedby="emailHelp"
								placeholder="Enter here" name="name">
						</div>

						<div class="form-group">
							<label for="email">User Email</label> <input type="email"
								class="form-control" id="email" aria-describedby="emailHelp"
								placeholder="Enter here" name="email">
						</div>

						<div class="form-group">
							<label for="password">User password</label> <input
								type="password" class="form-control" id="password"
								aria-describedby="emailHelp" placeholder="Enter here" name="password">
						</div>

						<div class="form-group">
							<label for="phone">User phone number</label> <input type="tel"
								class="form-control" id="phone" aria-describedby="emailHelp"
								placeholder="Enter here" name="phone">
						</div>

						<div class="form-group">
							<label for="Address">User Address</label>
							<textarea style="height: 150px;" class="form-control"
								placeholder="enter your address here " name="address"></textarea>

						</div>

						<div class="container text-center">

							<button class="btn btn-outline-success">Register</button>
							<button class="btn btn-outline-warning">Cancel</button>

						</div>

					</form>

				</div>

			</div>


		</div>

	</div>
</div>
	

</body>
</html>