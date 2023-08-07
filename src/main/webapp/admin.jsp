<%@page import="java.util.List"%>
<%@page import="com.sr.mycart.Dao.CategoryDao"%>
<%@page import="com.sr.mycart.dto.Category"%>

<%@page import="com.sr.mycart.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>






<%
User user = (User) session.getAttribute("current-user");
//if outsiders try to access the admin page using url.
if (user == null) {
	session.setAttribute("message", "you are not loged in login first");
	response.sendRedirect("login.jsp");
	return;
} else {//if non admin try to acces the admin page by changing url from user to admin
	if (!user.isAdmin()) {
		session.setAttribute("message", "you are not an admin");
		response.sendRedirect("login.jsp");
		return;
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>


	<div class="container admin">
		<%@include file="components/navbar.jsp"%>

		<div class="container-fluid mt-3">

			<%@include file="components/message.jsp"%>


		</div>
		<div class="row mt-3">
			<!-- first column -->
			<div class="col-md-4">
				<!-- first card -->
				<div class="card">

					<div class="card-body text-center">


						<!-- this container contains image with and properties defined -->
						<div class="container">

							<img style="max-width: 125px" class="img-fluid" alt="users_icon"
								src="img/man.png">

						</div>


						<h1>324</h1>
						<h1>Users</h1>

					</div>


				</div>


			</div>
			<div class="col-md-4">
				<!-- second card -->
				<div class="card">
					<div class="card-body text-center">
						<div class="container">

							<img style="max-width: 125px" class="img-fluid" alt="users_icon"
								src="img/categories.png">

						</div>
						<h1>324</h1>
						<h1>Categories</h1>

					</div>


				</div>


			</div>
			<div class="col-md-4">
				<!-- third box/ card -->
				<div class="card">
					<div class="card-body text-center">
						<div class="container">

							<img style="max-width: 125px" class="img-fluid" alt="users_icon"
								src="img/package.png">

						</div>

						<h1>324</h1>
						<h1>Products</h1>

					</div>


				</div>


			</div>


		</div>

		<!--second row-->

		<div class="row mt-4">
			<!-- 2nd row first column -->
			<div class="col-md-6">

				<div class="card" data-toggle="modal"
					data-target="#add-product-modal">


					<div class="card-body text-center">
						<div class="container">

							<img style="max-width: 125px" class="img-fluid" alt="users_icon"
								src="img/add-cart.png">

						</div>

						<p class="mt-3">click here to add products</p>
						<h1>Add products</h1>

					</div>


				</div>

			</div>
			<!-- 2nd row 2nd col -->
			<div class="col-md-6">

				<div class="card" data-toggle="modal"
					data-target="#add-category-modal">
					<div class="card-body text-center">
						<div class="container">

							<img style="max-width: 125px" class="img-fluid" alt="users_icon"
								src="img/app.png">

						</div>

						<p class="mt-3">click here to add new categories</p>
						<h1>Add categories</h1>

					</div>


				</div>
			</div>
		</div>
	</div>



	<!-- this is category model -->

	<!-- Button trigger modal -->

	<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#add-category-modal">Launch demo modal</button>
 -->
	<!-- Modal -->
	<div class="modal fade" id="add-category-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg">
					<h5 class="modal-title" id="exampleModalLabel">Fill category
						details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="SaveCategory" method="post">

						<input type="hidden" name="operation" value="addcategory">



						<div class="form-group">

							<input type="text" class="form-control" name="catTitle"
								placeholder="Enter category title" required="required" />
						</div>

						<div class="form-group">
							<textarea rows="" cols="" style="height: 300px"
								name="catDescription" class="form-control"
								placeholder="Enter category description"></textarea>

						</div>
						<div class="container text-center">

							<button class="btn btn-outline-success">Add Category</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>



						</div>



					</form>




				</div>

			</div>
		</div>
	</div>

	<!-- end of category model -->

	<!-- +++++++++++++++++++++++++++++++++++========++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- Start of Product model -->





	<!-- Modal -->
	<div class="modal fade" id="add-product-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<!--form  -->
					<!-- enctype multipart tag represents that we are using multimedia tag  -->
					<form action="ProductDetailsServlet" method="post"
						enctype="multipart/form-data">

						<!--Product Title-->
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Enter title of product " name="pName"
								required="required">
						</div>



						<!-- 						product description-->
						<div class="form-group">
							<textarea style="height: 150px" class="form-control"
								placeholder="Enter product desription" name="pDescription"></textarea>
						</div>

						<!-- product price -->
						<div class="form-group">
							<input type="number" class="form-control"
								placeholder="Enter price of product " name="pPrice"
								required="required">
						</div>

						<!-- product discount -->
						<div class="form-group">
							<input type="number" class="form-control"
								placeholder="Enter product discount " name="pdiscount"
								required="required">
						</div>
						<!--product Quantity  -->
						<div class="form-group">
							<input type="number" class="form-control"
								placeholder="Enter product Quantity" name="pQuantity"
								required="required">
						</div>
						<!-- product categories -->
						<%
						CategoryDao cdao = new CategoryDao();
						List<Category> list = cdao.displayCategory();
						%>

						<div class="form-group">

							<select name="catId" class="form-control" id="">


								<%
								for (Category c : list) {
								%>

								<option value="<%=c.getCategoryId()%>"><%=c.getCategoryTitle()%></option>
								<%
								}
								%>



							</select>
						</div>

						<!-- product file -->

						<div class="form-group">
							<label for="pPic">Select picture of the product</label> <br>
							<input type="file" id="pPic" name="pPic" readonly="readonly">


						</div>


						<div class="container text-center">

							<button class="btn btn-outline-success">Add Product</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>


						</div>




						<!--Submit Button -->






						<!-- End of form -->


					</form>





				</div>

			</div>
		</div>
	</div>






	<!--End of Product modal  -->
</body>
</html>