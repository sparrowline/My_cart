package com.sr.mycart.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sr.mycart.dto.Category;
import com.sr.mycart.dto.Product;
import com.sr.mycart.service.CategoryService;
import com.sr.mycart.service.ProductService;

@MultipartConfig()
@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Product product = new Product();

		// storing it explicitly in variable we want the id to find the object of
		// particular category through which we can save the category
		int catId = Integer.parseInt(req.getParameter("catId"));

		product.setpName(req.getParameter("pName"));
		product.setpDesc(req.getParameter("pDescription"));
		product.setpDiscount(Integer.parseInt(req.getParameter("pdiscount")));
		product.setpPrice(Integer.parseInt(req.getParameter("pPrice")));
		product.setpQuantity(Integer.parseInt(req.getParameter("pQuantity")));
		
		
		//product.setpId(catId);

		Part part = req.getPart("pPic");

		// here photo name is string format so to get the name from the file/document
		// uploaded we are extracting the name of the photo
		product.setpPhoto(part.getSubmittedFileName());

		// getCategoryById (to save the category)

		CategoryService categoryService = new CategoryService();
		Category category = categoryService.getCategoryById(catId);
		// saving the category.
		product.setCategory(category);

		// saving product.
		ProductService productService = new ProductService();
		productService.saveProduct(product);

		System.out.println("product saved successfully");

		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("message", "Product is added successfully.....");
		resp.sendRedirect("admin.jsp");

		// Find the path to upload the file

//		it is depricated hence we are not using this
//		String path= req.getRealPath("img");
//		

		ServletContext context = req.getServletContext();
		String path = context.getRealPath("img") + File.separator + "products" + File.separator
				+ part.getSubmittedFileName();

		// uploading file code here.

		try {
			// to write the data
			FileOutputStream fos = new FileOutputStream(path);

			// to read the data
			InputStream inputStream = part.getInputStream();

			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);

			// writing the data
			fos.write(data);

			fos.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println(path + "    1");

	}

}
