package com.bitwise.OnlineShopping.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {
	private List<String> list;
	Map<String, ProductInfo> map1=new HashMap<>();
	private double sum;
	public Products() {
		map1.put("T-Shirt", new ProductInfo("T-Shirt", 250, "red", 42, 0,1));
		map1.put("Pant",new ProductInfo("Pant", 1000, "blue", 34, 0,3));
		map1.put("Shirt",new ProductInfo("Shirt", 500, "black", 40, 0,4));
		map1.put("Trouser", new ProductInfo("trouser", 2500, "gray", 30, 0,3));
	}
	@Override
	public String toString() {
		return "Products [map1= " + map1 + " ] ";
	}
	public Map<String, ProductInfo> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, ProductInfo> map) {
		this.map1 = map;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	

}
