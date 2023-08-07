package com.sr.mycart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sr.mycart.dto.User;
@WebServlet("/updatemykartUser")
public class UpdateUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("name");
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		User user = new User();
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserAddress(address);
		user.setUserPassword(password);
		user.setUserPhone(phone);
		
		
	}
	
	

}
