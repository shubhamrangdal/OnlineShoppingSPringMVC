package com.bitwise.OnlineShopping.model;

public class ProductInfo {
	
	private String name,  color;
	private int size,quantity,stock;
	double price;
	
	public ProductInfo(String name, double price, String color, int size, int quantity,int stock) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.stock=stock;
	}
	


	@Override
	public String toString() {
		return "ProductInfo  name = " + name + ", color = " + color + ", size = " + size + ", quantity = " + quantity
				+ ", remaining stock = " + stock + ", price = " + price + "]";
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}
}
