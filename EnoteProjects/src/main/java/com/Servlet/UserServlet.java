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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	HttpSession  session = req.getSession();
	
	String fullname = req.getParameter("fullname");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	out.println(fullname  + email+ password);
	
	UserDetails  u = new UserDetails();
	
	u.setFullname(fullname);
	u.setEmail(email);
	u.setPassword(password);
	
	
	
	dao d= new dao(DBConnect.getConn());
	
	boolean bo = d.addUser(u);
	
	if (bo) {
		
		session.setAttribute("success", "Registration Successfully. ");
	   resp.sendRedirect("register.jsp");
	}else {
		
		session.setAttribute("failed", "Somthing went wrong. ");
		   resp.sendRedirect("register.jsp");
	}
}
	
	
}
