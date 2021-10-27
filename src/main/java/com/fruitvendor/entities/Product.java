package com.fruitvendor.entities;

public class Product {
	private Integer productID;
    private String productName;
    private Double productPrice;
    private String productPhoto;
    
    public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}

	public Product(Integer productID, String productName, Double productPrice, String productPhoto) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productPhoto = productPhoto;
    }
    
}
