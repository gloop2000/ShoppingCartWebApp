package com.fruitvendor.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fruitvendor.entities.Product;

public class ProductList {
	// Map product to their Stock in Store
	private static Map<Product, Double> productsInStore = new LinkedHashMap<>();
	private static Map<Integer, Product> productAndIdMap = new HashMap<>();

	public ProductList() {
		// TODO Auto-generated constructor stub
		this.initializeProducts();
	}

	// initialize products in store
	void initializeProducts() {
		String[] productNames = { "Apple", "Mango", "Pear", "Banana", "Grape" };
		Double[] productPrice = { 100.00d, 120.00d, 140.00d, 74.00d, 80.00d };
		Double[] stock = { 10.0d, 25.0d, 8.0d, 30.0d, 5.0d };
		String[] photoPath = {"apple.png","mango.png","pear.png","banana.png","grape.png"};
		for (int index = 0; index < productNames.length; index++) {
			Product tempProduct = new Product(index + 1, productNames[index], productPrice[index], photoPath[index]);
			productsInStore.put(tempProduct, stock[index]);
			productAndIdMap.put(index + 1, tempProduct);
		}
	}

	// Find Product By ProductID
	public Product findProductByProductID(int productID) {
		return productAndIdMap.get(productID);
	}

	// Check if Product is in Stock
	public boolean isProductInStock(Product currentProduct, double quantityRequested) {
		double currentStock = productsInStore.get(currentProduct);
		if (currentStock == 0)
			return false;
		if (currentStock < quantityRequested)
			return false;
		return true;
	}

	// Add quantity to Product Stock
	public void addToProductStock(Product currentProduct, double quantityToAdd) {
		double currentStock = productsInStore.get(currentProduct);
		productsInStore.put(currentProduct, currentStock + quantityToAdd);
	}

	// Remove quantity from Product Stock
	public void removeFromProductStock(Product currentProduct, double quantityToRemove) {
		double currentStock = productsInStore.get(currentProduct);
		productsInStore.put(currentProduct, currentStock - quantityToRemove);
	}

	public int getSize() {
		return productsInStore.size();
	}

	public Map<Product, Double> getAllProductStockMap() {
		return productsInStore;
	}

	public double getProductStock(Product currentProduct) {
		return productsInStore.get(currentProduct);
	}
	
	public List<Product> getALLProducts(){
		List<Product> allProductList = new ArrayList<>(productsInStore.keySet());
		return allProductList;
	}
}
