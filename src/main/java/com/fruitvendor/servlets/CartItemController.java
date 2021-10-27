package com.fruitvendor.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitvendor.entities.Product;
import com.fruitvendor.models.Cart;

@WebServlet("/edit-cart")
public class CartItemController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cart userCart;
	Product currentProduct;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		String action = request.getParameter("action");
		userCart = (Cart) request.getSession().getAttribute("userCart");
		currentProduct = userCart.findProductByProductID(productID);
		switch (action) {
		case "removeItem":
			doGet_Remove(request, response);
			break;
		case "increaseItemQuantity":
			doGet_AddQuantity(request, response);
			break;
		case "decreaseItemQuantity":
			doGet_DecreaseQuantity(request, response);
			break;
		default:
			break;
		}
		request.getSession().setAttribute("userCart", userCart);
		response.sendRedirect("cart.jsp");
	}
	
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userCart.removeProductFromCart(currentProduct);
		if(userCart.getNumberOfItemsInCart() == 0)
			userCart = null;
	}
	
	protected void doGet_AddQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userCart.addProductToCart(currentProduct, 1.0);
	}
	
	protected void doGet_DecreaseQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userCart.removeProductFromCart(currentProduct, 1.0);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
}
