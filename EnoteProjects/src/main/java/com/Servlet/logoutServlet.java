package com.Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();

			session.removeAttribute("userD");

			HttpSession session2 = req.getSession();
			session2.setAttribute("LogoutMsg", "Logout Successfully");
			resp.sendRedirect("login.jsp");
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
}
