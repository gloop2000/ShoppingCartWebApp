<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${currentUser != null && isLoginSuccessful == null }">
	<c:redirect url="/home"></c:redirect>
</c:if>

<!DOCTYPE html>
<html>
<head>

<title>User Login</title>
<%@ include file="/includes/header.jsp"%>

<body>
	<%@ include file="/includes/navbar.jsp"%>
	<c:choose>
		<c:when test="${isLoginSuccessful == true }">
			<div class="container">
				<div class="card w-50 mx-auto my-5">
					<div class="card-header text-center">Logged In Successfully</div>
					<div class="card-body">
						<form action="index.jsp">
							<div class="text-center">
								<button type="submit" class="btn btn-primary">OK</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${isLoginSuccessful == false }">
			<div class="container">
				<div class="card w-50 mx-auto my-5">
					<div class="card-header text-center">Could Not Login. Please
						Try Again</div>
					<div class="card-body">
						<form action="login.jsp">
							<c:set  var="isLoginSuccessful" value="${null }" scope="request"></c:set>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">OK</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div class="card w-50 mx-auto my-5">
					<div class="card-header text-center">User Login</div>
					<div class="card-body">
						<form action="user-login" method="post">
							<div class="form-group">
								<label>User Name</label> <input type="text" name="userName"
									class="form-control" placeholder="Enter username">
							</div>
							<div class="form-group">
								<label>Password</label> <input type="password"
									name="userPassword" class="form-control" placeholder="Password">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>
						</form>
					</div>
					<div class="card-footer text-muted text-center">
						New User? <a href="register.jsp">Sign Up</a>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>