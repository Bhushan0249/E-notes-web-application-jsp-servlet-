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

@WebServlet("/editServlet")
public class editServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	try {
		
		int noteId = Integer.parseInt(req.getParameter("noteid"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
	
//		System.out.println(noteId+title+content);
		
		
		postDAO po= new postDAO(DBConnect.getConn());
		boolean f = po.postUpdate(noteId, title, content);
		
//		System.out.println(f);
		if(f) {
			HttpSession session = req.getSession();
			session.setAttribute("updateMsg", "Notes Update Successfully");
			resp.sendRedirect("showNotes.jsp");
			
			
			System.out.println("data inserted");
		}else {
			System.out.println("NOT INSERTED");
		}
		
		
	} catch (Exception e) {
		e.getStackTrace();
	}
	
	}
}
