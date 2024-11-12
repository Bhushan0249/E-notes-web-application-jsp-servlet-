package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.dao;
import com.User.UserDetails;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter out= resp.getWriter();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		out.println(email+ password);
		
		UserDetails us = new UserDetails();
		
	us.setEmail(email);
	us.setPassword(password);
	
	dao d= new dao(DBConnect.getConn());
	 UserDetails user = d.loginUser(us);
		
		if(user!=null) {
			session.setAttribute("userD", user);
			
			resp.sendRedirect("home.jsp");
		}else {
			out.println("Somethin wrong...");
			session.setAttribute("log_failed", "Invalid Username And Password");
		resp.sendRedirect("login.jsp");
		}
	}
	
}
