<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${currentUser != null && isUserCreated==null }">
	<c:redirect url="/home"></c:redirect>
</c:if>

<!DOCTYPE html>
<html>
<head>
<title>User Registration</title>
<%@ include file="/includes/header.jsp"%>

<script>
function validateForm() {
  let userPassword = document.forms["registration-form"]["userPassword"].value;
  let confirmPassword = document.forms["registration-form"]["confirmPassword"].value;
  if (userPassword != confirmPassword) {
    alert("Password and Confirm Password are not same");
    return false;
  }
}
</script>
</head>

<body>
	<%@ include file="/includes/navbar.jsp"%>
	<c:choose>
		<c:when test="${isUserCreated == true }">
			<div class="container">
				<div class="card w-50 mx-auto my-5">
					<div class="card-header text-center">User Successfully
						Created</div>
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
		<c:when test="${isUserCreated == false }">
			<div class="container">
				<div class="card w-50 mx-auto my-5">
					<div class="card-header text-center">User Already Exists!</div>
					<div class="card-body">
						<form action="register.jsp">
							<c:set var="isUserCreated" value="${null }" scope="request"></c:set>
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
					<div class="card-header text-center">User Registration</div>
					<div class="card-body">
						<form name="registration-form" action="user-register" onsubmit="return validateForm()" method="post">
							<div class="form-group">
								<label>User Name</label> <input type="text" name="userName"
									class="form-control" placeholder="Enter username" required>
							</div>
							<div class="form-group">
								<label>Password</label> <input type="password"
									name="userPassword" class="form-control" placeholder="Password"
									required>
							</div>
							<div class="form-group">
								<label>Confirm Password</label> <input type="password"
									name="confirmPassword" class="form-control" placeholder="Confirm Password"
									required>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Sign Up</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>