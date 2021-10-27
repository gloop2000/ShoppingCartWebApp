package com.fruitvendor.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitvendor.entities.Product;
import com.fruitvendor.models.Cart;

@WebServlet("/remove-from-cart")
public class RemoveFromCartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cart userCart;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		userCart = (Cart) request.getSession().getAttribute("userCart");
		Product currentProduct = userCart.findProductByProductID(productID);
		userCart.removeProductFromCart(currentProduct);
		if(userCart.getNumberOfItemsInCart() == 0)
			userCart = null;
		request.getSession().setAttribute("userCart", userCart);
		response.sendRedirect("cart.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
}
