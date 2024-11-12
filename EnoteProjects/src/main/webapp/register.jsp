<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allComponet/allcss.jsp"%>
</head>
<body>
	<%@include file="allComponet/navbar.jsp"%>

	<div class="continer-fluid div-color ">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center bg-custom">
						<i class="fa fa-user-plus t fa-3x" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>



					<%
					String regmsg = (String) session.getAttribute("success");

					if (regmsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=regmsg%>Go
						to login<a href="login.jsp">Click here</a>
					</div>
					<%
					
					session.removeAttribute("success");
					}
					%>


					<%
					String faileds = (String) session.getAttribute("failed");

					if (faileds != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=faileds%></div>
					<%
					session.removeAttribute("failed");
					}
					%>



					<div class="card-body">
						<form action="UserServlet" method="post">
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="fullname">

							</div>
							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email">

							</div>
							<div class="form-group">
								<label>Enter Password</label> <input name="password"
									type="password" class="form-control" id="exampleInputPassword1">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="allComponet/footer.jsp"%>
</body>
</html>