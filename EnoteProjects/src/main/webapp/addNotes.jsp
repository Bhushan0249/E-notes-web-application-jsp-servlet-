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
<title>Insert title here</title>
<%@include file="allComponet/allcss.jsp"%>
</head>
<body>

	<div class="container-fluid">
		<%@include file="allComponet/navbar.jsp"%>

		<h1 class="text-center">Add Your Notes</h1>


		<div class="container">

			<div class="row">
				<div class="col-md-12">

					<form action="addNotes" method="post">
						<div class="form-group">


							<%
							UserDetails us = (UserDetails) session.getAttribute("userD");

							if (us != null) {
							%>


							<input type="hidden" value="<%=us.getId()%>" name="uid">

							<%
							}
							%>




							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title">
						</div>

						<div class="form-group">
							<pre>
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="10" cols="" class="form-control" name="content"></textarea>
                           </pre>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add Notes</button>

						</div>

					</form>

				</div>

			</div>
		</div>
	</div>
	<%@include file="allComponet/footer.jsp"%>
</body>
</html>