<nav class="navbar navbar-expand-lg navbar-light bg-light custom-bg">
	<%@page import="com.sr.mycart.dto.User"%>
	<%
	User user1 = (User) session.getAttribute("current-user");
	%>

	<div class="container">
		<a class="navbar-brand" href="index.jsp">my_cart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Categories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>

			</ul>
			<ul class="navbar-nav ml-auto">
			
			
			
				<li class="nav-item active"><a class="nav-link"
					href="#!" data-toggle="modal" data-target="#cart"> <i class="fa fa-cart-plus" style="font-size: 20px;"></i><span class="ml-0 cart-items">(0)</span> </a></li>
				
			


				<%
				if (user1 == null) {
				%>

				<li class="nav-item active"><a class="nav-link"
					href="login.jsp">Login</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="register.jsp">Register</a></li>
				<%
				} else {
				%>
				<%--we are fetching the user data here using the sesion refrence variable who is logined   --%>
				<li class="nav-item active"><a class="nav-link" href="#!"><%=user1.getUserName()%></a></li>

				<li class="nav-item active"><a class="nav-link"
					href="LogOutServlet">Logout</a></li> <!-- using logout servlets remove attribute method the delete the sesion created  -->

				<%
				}
				%>

			 </ul>
		</div>
	</div>
</nav>