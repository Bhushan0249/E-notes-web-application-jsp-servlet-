<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<%@include file="allComponet/allcss.jsp"%>
</head>
<body>
	<%@include file="allComponet/navbar.jsp"%>

	<div class="continer-fluid div-color ">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center bg-custom">
						<!-- <i class="fa fa-user-plus t fa-3x" aria-hidden="true"></i> -->
						<i class="fa fa-sign-in fa-3x" aria-hidden="true"></i>
						<h4>Login Page</h4>
					</div>





					<%
					String invMsg = (String) session.getAttribute("log_failed");

					if (invMsg != null) {
					%>


					<div class="alert alert-danger" role="alert"><%=invMsg%></div>

					<%
					session.removeAttribute("log_failed");
					}
					%>


					<%
					String withoutLogin = (String) session.getAttribute("login_error");

					if (withoutLogin != null) {
					%>

					<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>



					<%
					session.removeAttribute("login_error");

					}
					%>

					<%
					String lgMsg = (String) session.getAttribute("LogoutMsg");

					if (lgMsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=lgMsg%></div>
					<%
					session.removeAttribute("LogoutMsg");
					}
					%>

					<div class="card-body">
						<form action="login" method="post">

							<div class="form-group">
								<label>Enter Username</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email">

							</div>
							<div class="form-group">
								<label>Enter Password</label> <input name="password"
									type="password" class="form-control" id="exampleInputPassword1">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="allComponet/footer.jsp"%>
</body>
</html>