package com.fruitvendor.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitvendor.models.Cart;

@WebServlet("/cart-check-out")
public class CartCheckOutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cart userCart;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("currentUser")!= null)
			response.sendRedirect("order.jsp");
		else
			response.sendRedirect("cart.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
}
