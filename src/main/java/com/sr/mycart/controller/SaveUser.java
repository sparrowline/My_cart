package com.sr.mycart.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sr.mycart.dto.User;
import com.sr.mycart.service.UserService;

import lombok.Data;

//@WebServlet("/registermykart")
//public class SaveUser extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		// int id = Integer.parseInt(req.getParameter("id"));
//		String userName = req.getParameter("name");
//		String email = req.getParameter("email");
//		String userPassword = req.getParameter("password");
//		String phone = req.getParameter("phone");
//		String address = req.getParameter("address");
//
//		User user = new User();
//
//		// user.setUserId(id);
//		user.setUserName(userName);
//		user.setUserEmail(email);
//		user.setUserPassword(userPassword);
//		user.setUserPhone(phone);
//		user.setUserAddress(address);
//
//		UserService userService = new UserService();
//		userService.saveuser(user);
//
//		HttpSession httpSession = req.getSession();
//		httpSession.setAttribute("message","login successfull !!");
//		resp.sendRedirect("register.jsp");
//		return;
//		
//
//
//	}
//}

@WebServlet("/registermykart")
public class SaveUser extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("name");
        String email = req.getParameter("email");
        String userPassword = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // Check if any field is blank
        if (userName.isEmpty() || email.isEmpty() || userPassword.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("message", "Please enter all the details");
            resp.sendRedirect("register.jsp");
            return;
        }

        User user = new User();
        user.setUserName(userName);
        user.setUserEmail(email);
        user.setUserPassword(userPassword);
        user.setUserPhone(phone);
        user.setUserAddress(address);

        UserService userService = new UserService();
        userService.saveUser(user);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("message", "Registration successful");
        resp.sendRedirect("register.jsp");
    }

    }


