<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User login - MyCart</title>
<%@ include file="components/common_css_js.jsp"%>

</head>
<%@include file="components/navbar.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<div class="card mt-3">
					<%@include file="components/message.jsp" %>

					<div class="card-header  custom-bg ">
						<h3>Login here.</h3>

					</div>

					<div class="card-body">
					
					
						<form action="loginmycartservlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="email"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="password">
							</div>
							<div class="container text-center ">
								<a href="register.jsp" class="text-center d-block mb-2">if
									not registered click here</a>
								<button type="submit" class="btn btn-primary border-0">Submit</button>
								<button type="reset" class="btn btn-primary border-0">Reset</button>

							</div>
						</form>

					</div>



				</div>
			</div>

		</div>

	</div>

</body>
</html>