<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img {
	background: url("img/Enotes.jpg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>


<%@include file="allComponet/allcss.jsp"%>
</head>
<body>
	<%@include file="allComponet/navbar.jsp"%>

	<div class="container-fluid back-img">

		<div class="text-center">


			<h1 class="text-white">
				<i class="fa fa-book" aria-hidden="true"></i> E Notes- Save Your
				Notes
			</h1>
			<a href="login.jsp" class="btn btn-light"><i
				class="fa fa-sign-in" aria-hidden="true"></i> Login</a>
				<a href="register.jsp" class="btn btn-light">
				<i class="fa fa-address-book" aria-hidden="true"></i> Register</a>
				
				

		</div>

	</div>



	<%@ include file="allComponet/footer.jsp"%>
</body>
</html>