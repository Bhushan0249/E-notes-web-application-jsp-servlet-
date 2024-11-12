<%@page import="com.User.post"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.postDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDetails us3 = (UserDetails) session.getAttribute("userD");

if (us3 == null) {

	response.sendRedirect("login.jsp");

	session.setAttribute("login_error", "please Login");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show Notes</title>
<%@include file="allComponet/allcss.jsp"%>
</head>
<body>

	<%@ include file="allComponet/navbar.jsp"%>
	<%
	String msg = (String) session.getAttribute("updateMsg");
	if (msg != null) {
	%>
	<div class="alert alert-success text-center" role="alert"><%=msg%></div>
	<%
	session.removeAttribute("updateMsg");
	}
	%>
	<%
	String wrongmsg = (String) session.getAttribute("wrongMsg");
	if (wrongmsg != null) {
	%>
	<div class="alert alert-danger text-center" role="alert"><%=wrongmsg%></div>
	<%
	session.removeAttribute("wrongMsg");
	}
	%>
	<div class="container">
		<h2 class="text-center">All Notes:</h2>

		<div class="row">
			<div class="col-md-12">

				<%
				if (us3 != null)

				{
					postDAO ob = new postDAO(DBConnect.getConn());
					List<post> pos = ob.getData(us3.getId());

					for (post po : pos) {
				%>
				<div class="card mt-3">

					<img alt="" src="img/peaper2.jpg" class="card-img-top mt-2 mx-auto"
						style="max-width: 100px;">

					<div class="card-bady p-4">
						<h5 class="card-title"><%=po.getTitle()%></h5>

						<p><%=po.getContent()%></p>

						<p>
							<b class="text-success">Published By: <%=us3.getFullname()%><br>
								<br>
							</b> <b class="text-primary"></b>
						</p>
						<p>
							<b class="text-success">Published Date:<%=po.getUdate()%> <br>
								<br>
							</b> <b class="text-success"></b>
						</p>

						<div class="container text-center mt-2">

							<a href="deleteServlet?note_id=<%=po.getMid()%>"
								class="btn btn-danger">Delete</a> <a
								href="edit.jsp?note_id=<%=po.getMid()%>" class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>
				<%
				}
				}
				%>
			</div>
		</div>
	</div>


</body>
</html>