package com.fruitvendor.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitvendor.entities.Product;
import com.fruitvendor.models.Cart;
import com.fruitvendor.models.ProductList;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cart userCart;
	ProductList productsInStore = new ProductList();
	boolean itemAddedToCart;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(itemAddedToCart) {
			response.sendRedirect("index.jsp");
		}
		else {
			response.sendRedirect("home");			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		double productQuantity = Double.parseDouble(request.getParameter("QTY"));
		if (userCart == null) {
			userCart = new Cart();
		}
		Product currentProduct = userCart.findProductByProductID(productID);
		if (productsInStore.isProductInStock(currentProduct, productQuantity)) {
			userCart.addProductToCart(currentProduct, productQuantity);
			itemAddedToCart = true;
			request.getSession().setAttribute("userCart", userCart);
		} else {
			itemAddedToCart = false;
			request.getSession().setAttribute("isItemAdded", false);
			request.getSession().setAttribute("currentProductStock", productsInStore.getProductStock(currentProduct));
		}
		response.sendRedirect("add-to-cart");
	}
}
