<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%
UserDetails us2 = (UserDetails) session.getAttribute("userD");

if (us2 == null) {

	response.sendRedirect("login.jsp");
	
	session.setAttribute("login_error", "please Login");
}
%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allComponet/allcss.jsp" %>
</head>
<body>

<div class="container-fluid">
<%@include file="allComponet/navbar.jsp" %>
<div class="card py-5">
<div class="card-bady text-center">
<img alt="" src="img/peaper2.jpg" class="img-fluid mx-auto " style="max-width: 300px;">
<h1>START TAKING YOUR NOTES</h1>
<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
</div>
</div>
</div>


 <%@include file="allComponet/footer.jsp" %>
</body>
</html>