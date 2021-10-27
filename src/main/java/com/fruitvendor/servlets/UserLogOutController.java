package com.fruitvendor.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitvendor.models.Cart;


@WebServlet("/user-logout")
public class UserLogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("currentUser") != null) {
			request.getSession().removeAttribute("currentUser");
			Cart currentCart = (Cart)request.getSession().getAttribute("userCart");
			if(currentCart != null) {
				currentCart.removeAllProductsFromCart();;
				request.getSession().removeAttribute("userCart");
			}
			response.sendRedirect("login.jsp");
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
