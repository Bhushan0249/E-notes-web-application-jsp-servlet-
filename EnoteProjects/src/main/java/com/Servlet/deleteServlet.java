package com.Servlet;

import java.io.IOException;

import com.DAO.postDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session  = null;
	
		int noteid= Integer.parseInt(req.getParameter("note_id"));
		
		
	postDAO po = new postDAO(DBConnect.getConn());
	
	boolean f = po.deletNotes(noteid);
	
	if(f) {
		session = req.getSession();
		session.setAttribute("updateMsg","Notes Deleted Successfully");
		resp.sendRedirect("showNotes.jsp");
		
		
		System.out.println("data Deleted Successfully");
	}else {
		
		session = req.getSession();
		session.setAttribute("wrongMsg","Something Wrong Please Try Again");
		resp.sendRedirect("showNotes.jsp");
		
		System.out.println("data NOT deleted");
	}
	
		
	
	
	}

}
