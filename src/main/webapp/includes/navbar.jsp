<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-md navbar-light bg-light main-menu"
	style="box-shadow: none">
	<div class="container">

		<a class="navbar-brand" href="/home">
			<h4 class="font-weight-bold">Fruit Vendor</h4>
		</a>

		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${userCart != null }">
					<li class="nav-item"><a class="btn btn-link" href="cart.jsp"><i
							class="bx bxs-cart icon-single"></i> <span
							class="badge badge-danger"> <c:out
									value="${userCart.getNumberOfItemsInCart() }"></c:out>
						</span></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="btn btn-link" href="cart.jsp"><i
							class="bx bxs-cart icon-single"></i> <span
							class="badge badge-danger">0</span></a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>

				<c:when test="${currentUser != null }">
					<li class="nav-item ml-md-3"><a class="btn btn-primary"
						style="color: white"> <c:out
								value="Hello, ${currentUser.userName }"></c:out>
					</a></li>
					<li class="nav-item ml-md-3"><a class="btn btn-primary"
						style="color: white" href="user-logout">Logout</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item ml-md-3"><a class="btn btn-primary"
						href="/login.jsp"><i class="bx bxs-user-circle mr-1"></i> Log
							In / Register</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>