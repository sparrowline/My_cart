<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="com.sr.mycart.helper.Helper"%>
<%@page import="com.sr.mycart.dto.Category"%>
<%@page import="com.sr.mycart.Dao.CategoryDao"%>
<%@page import="com.sr.mycart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.sr.mycart.Dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page- MyCart</title>
<%@ include file="components/common_css_js.jsp"%>
<%@include file="components/navbar.jsp"%>


</head>
<body>

	<div class="container-fluid">
		<div class="row mt-3 mx-2">
			<%
			String cat = request.getParameter("category");

			ProductDao dao = new ProductDao();
			List<Product> list = null;

			if (cat == null || cat.trim().equals("all")) {

				list = dao.getAllProducts();
			} else {
				int cid = Integer.parseInt(cat.trim());
				list = dao.getAllProductsById(cid);
			}

			CategoryDao categoryDao = new CategoryDao();
			List<Category> clist = categoryDao.displayCategory();
			%>
			<!--Show Categories  -->
			<div class="col-md-2">
				<div class="list-group mt-4">
					<a href="index.jsp?category=all"
						class="list-group-item list-group-item-action active"> All
						Products </a>


					<%
					for (Category category : clist) {
					%>

					<a href="index.jsp?category=<%=category.getCategoryId()%>"
						class="list-group-item list-group-item-action"><%=category.getCategoryTitle()%></a>



					<%
					}
					if (list.size() == 0) {
					out.println("<h3>No Products are there in this category</h3>");
					}
					%>
				</div>


			</div>
			<!-- category ended here -->

			<!--Show Products  -->
			<div class="col-md-10">

				<!-- creating one row in Show products -->
				<div class="row mt-4">
					<!--col:12  -->
					<div class="col-md-12">
						<div class="card-columns">
							<!--Traversing Products  -->
							<%
							for (Product product : list) {
							%>


							<div class="card">

								<div class="card-body">

									<div class="container text-center">
										<!--using container to keep the img in center   -->
										<img alt="" src="img/products/<%=product.getpPhoto()%>"
											style="max-height: 350px; max-width: 100%; width: auto;"
											class="card-img-top m2">


									</div>

									<h5 class="card-title"><%=product.getpName()%></h5>
									<p class="card-text"><%=Helper.get10Words(product.getpDesc())%></p>


								</div>

								<div class="card-footer text-center">

									<button class="btn custom-bg "
										onclick="add_to_cart(<%=product.getpId()%>,'<%=product.getpName()%>',<%=product.getPriceAfterApplyingDiscount()%>)">Add
										to cart</button>
									<button class="btn btn-outline-success ">
										&#8377;<%=product.getPriceAfterApplyingDiscount()%>/- <span
											class="text-secondary discount-label">&#8377;<%=product.getpPrice()%>,
											<%=product.getpDiscount()%> %off
										</span>
									</button>

								</div>




							</div>





							<%}%>

						</div>

					</div>



				</div>





			</div>



		</div>
	</div>

<%@include file="components/common_modals.jsp" %>

</body>
</html>