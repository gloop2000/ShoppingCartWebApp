package com.fruitvendor.models;

import java.util.HashMap;
import java.util.Map;

import com.fruitvendor.entities.Product;

public class Cart extends ProductList {
	//Map product to their quantities in cart
	private Map<Product,Double> userCart = new HashMap<>();
	double grandTotal =0;
	
	public void addProductToCart(Product currentProduct, Double requestedQuantity) {
		if(userCart.containsKey(currentProduct)) {
			double currentQuantity = userCart.get(currentProduct);
			userCart.put(currentProduct, currentQuantity + requestedQuantity);
		}
		else {
			userCart.put(currentProduct, requestedQuantity);
		}
		grandTotal += currentProduct.getProductPrice() * requestedQuantity;
	}
	
	public void removeProductFromCart(Product currentProduct, Double requestedQuantity) {
		if(userCart.containsKey(currentProduct)) {
			double currentQuantity = userCart.get(currentProduct);
			if(currentQuantity > requestedQuantity)
				userCart.put(currentProduct, currentQuantity - requestedQuantity);
			else
				userCart.remove(currentProduct);
			grandTotal -= currentProduct.getProductPrice() * requestedQuantity;
		}
	}
	
	public void removeProductFromCart(Product currentProduct) {
		grandTotal -= currentProduct.getProductPrice() * userCart.get(currentProduct);
		userCart.remove(currentProduct);
	}
	
	public void removeAllProductsFromCart() {
		grandTotal = 0;
		userCart.clear();
	}
	
	public Map<Product,Double> getAllProductsInCart() {
		return userCart;
	}
	
	public int getNumberOfItemsInCart() {
		if(userCart == null)
			return 0;
		return userCart.size();
	}
	
	public double getGrandTotal() {
		return grandTotal;
	}
}
