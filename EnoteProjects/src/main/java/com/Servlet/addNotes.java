package com.Servlet;

import java.io.IOException;

import com.DAO.postDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addNotes")
public class addNotes extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int uid =Integer.parseInt(req.getParameter("uid"));
	
	String title=req.getParameter("title");
	String content=req.getParameter("content");
	
	postDAO po = new postDAO(DBConnect.getConn());
	boolean f = po.addNotes(title, content, uid);
	
	
	if(f) {
		System.out.println("data inserted");
		resp.sendRedirect("showNotes.jsp");
	}else {
		System.out.println("data not inserted");
	}
	 
	 
	
	
	}

}
