<%@page import="com.User.post"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.DAO.postDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
UserDetails us1 = (UserDetails) session.getAttribute("userD");

if (us1 == null) {

	response.sendRedirect("login.jsp");
	
	session.setAttribute("login_error", "please Login");
}
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit page</title>
<%@include file="allComponet/allcss.jsp"%>
</head>
<body>




<%



int noteId= Integer.parseInt(request.getParameter("note_id"));


postDAO po = new postDAO(DBConnect.getConn());
post p=po.getDatabyid(noteId);



%>

	<div class="container-fluid">
		<%@include file="allComponet/navbar.jsp"%>

		<h1 class="text-center">Edit Your Notes</h1>


		<div class="container">

			<div class="row">
				<div class="col-md-12">

					<form action="editServlet" method="post">
					
					<input type="hidden" value="<%=noteId%>" name="noteid">
					
					
						<div class="form-group">

							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" value="<%=p.getTitle() %>" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="10" cols="" class="form-control"   name="content"><%=p.getContent() %></textarea>

						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Save Notes</button>

						</div>

					</form>

				</div>

			</div>
		</div>
	</div>
	
</body>
</html>