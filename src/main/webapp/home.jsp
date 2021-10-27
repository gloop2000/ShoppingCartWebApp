<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/includes/header.jsp" %>
	<title>Home</title>
</head>

<body>

	<%@ include file="/includes/navbar.jsp"%>

	<div class="container">
		<h4 style="text-align: center">Welcome to Fruit Vendor</h4>
		<h6 style="text-align: center">Fresh fruits, at your doorstep.</h6>
		<br>
		<div class="row">
			<c:forEach var="product" items="${listOfAllProducts }">
				<div class="col-md-3 my-3">
					<div class="card w-100">
						<img class="card-img-top"
							src="/assets/images/${product.productPhoto }"
							alt="Card image cap" width="80" height="150">
						<div class="card-body">
							<h6 class="card-title">
								Name:
								<c:out value="${product.productName } " />
							</h6>
							<h6 class="price">
								Price: &#x20b9;
								<c:out value="${product.productPrice }/Kg" />
							</h6>
							<form action="add-to-cart">
								<input type="hidden" name="productID"
									value="${product.productID }"> <label for="QTY">QTY
									(KG):</label> <input type="text" id="QTY" name="QTY" size="1" value="1">
								<br> <input class="btn btn-primary" type="submit"
									value="Add to Cart">
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>