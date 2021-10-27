<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Your Cart</title>
<%@ include file="/includes/header.jsp"%>
<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 25px;
}
</style>
</head>
<body>
	<%@ include file="/includes/navbar.jsp"%>
	<div class="container">
		<h4 style="text-align: center">
			Thank you for the Purchase,
			<c:out value="${currentUser.userName }!!!"></c:out>
		</h4>
		<br>
		<div class="container my-3">
			<div class="d-flex py-3">
				<h3>Total Price: &#x20b9; ${userCart.getGrandTotal()}</h3>
			</div>
			<table class="table table-light">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Price</th>
						<th scope="col">QTY</th>
						<th scope="col">Total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cartItem"
						items="${userCart.getAllProductsInCart() }">
						<tr>
							<td><c:out value="${cartItem.key.productName }"></c:out></td>
							<td><c:out value="${cartItem.key.productPrice }"></c:out></td>
							<td><c:out value="${cartItem.value }"></c:out></td>
							<td><c:out
									value="${cartItem.value * cartItem.key.productPrice }"></c:out>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>