package com.sr.mycart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sr.mycart.dto.Category;
import com.sr.mycart.service.CategoryService;
@WebServlet("/SaveCategory")
public class SaveCategory extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Category category = new Category();
		
		
		
		category.setCategoryTitle(req.getParameter("catTitle"));
		category.setCategoryDescription(req.getParameter("catDescription"));
		
		CategoryService categoryService = new CategoryService();
		categoryService.saveCategory(category);
		
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("message", "category added successfully");
		resp.sendRedirect("admin.jsp");
		
	}
}
