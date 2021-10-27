package com.fruitvendor.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitvendor.entities.Product;
import com.fruitvendor.models.Cart;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cart userCart;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		double productQuantity = Double.parseDouble(request.getParameter("QTY"));
		if(userCart == null) {
			userCart = new Cart();
		}
		Product currentProduct = userCart.findProductByProductID(productID);
		userCart.addProductToCart(currentProduct, productQuantity);
		request.getSession().setAttribute("userCart", userCart);
		response.sendRedirect("index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
}
