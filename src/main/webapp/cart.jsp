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
		<h4 style="text-align: center">Your Cart</h4>
		<br>
		<c:choose>
			<c:when test="${userCart != null }">
				<div class="container my-3">
					<div class="d-flex py-3">
						<h3>Total Price: &#x20b9; ${userCart.getGrandTotal()}</h3>
						<c:choose>
							<c:when test="${currentUser !=null }">
								<button class="mx-3 btn btn-primary"
									onclick="location.href='cart-check-out'">Check Out</button>
							</c:when>
							<c:otherwise>
								<button class="mx-3 btn btn-primary" title="Please Login"
									disabled>Check Out</button>
							</c:otherwise>
						</c:choose>
					</div>
					<table class="table table-light">
						<thead>
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Price</th>
								<th scope="col">QTY</th>
								<th scope="col">Total</th>
								<th scope="col">Cancel</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cartItem"
								items="${userCart.getAllProductsInCart() }">
								<tr>
									<td><c:out value="${cartItem.key.productName }"></c:out></td>
									<td><c:out value="${cartItem.key.productPrice }"></c:out>
									</td>
									<td><c:out value="${cartItem.value }"></c:out></td>
									<td><c:out
											value="${cartItem.value * cartItem.key.productPrice }"></c:out>
									</td>
									<td><a
										href="remove-from-cart?productID=${cartItem.key.productID }"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<h4 style="text-align: center">OOPS... There are no Items in
					your Cart</h4>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>