package com.sr.mycart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sr.mycart.Dao.UserDao;
import com.sr.mycart.dto.User;
import com.sr.mycart.service.UserService;

@WebServlet("/loginmycartservlet")
public class LoginUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserService userService = new UserService();
		User user = userService.getUserByEmailAndPassword(email, password);

		HttpSession httpSession = req.getSession();

		
		if (user != null) {
			//forward reqdispatcher
			//RequestDispatcher requestDispatcher = req.getRequestDispatcher("about.jsp");
			//requestDispatcher.forward(req, resp);
			
			//using sesion to forward it based on user type
			httpSession.setAttribute("current-user", user);
			if(user.isAdmin()) {
				//admin :- admin.jsp
				resp.sendRedirect("admin.jsp");
			}else if(!user.isAdmin()) {
				//normal :- normal.jsp
				resp.sendRedirect("normal.jsp");
			}else {
				//out.println("we have not identified user type");
			}

		} else{

			httpSession.setAttribute("message", "Invalid details!! try with another one");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
			
		}

	}

}
