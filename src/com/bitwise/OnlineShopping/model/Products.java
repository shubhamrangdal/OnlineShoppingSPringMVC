package com.bitwise.OnlineShopping.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {
	private List<String> map;
	Map<String, ProductInfo> map1=new HashMap<>();
	String str="shubham";
	public Products() {
		map1.put("Car", new ProductInfo("T-Shirt", 250, "red", 42, 1));
		map1.put("Pant",new ProductInfo("Pant", 1000, "blue", 34, 1));
		map1.put("Shirt",new ProductInfo("Shirt", 500, "black", 40, 1));
		map1.put("Item 4", new ProductInfo("trouser", 2500, "gray", 30, 1));
	}
	public Map<String, ProductInfo> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, ProductInfo> map) {
		this.map1 = map;
	}
	public List<String> getMap() {
		return map;
	}
	public void setMap(List<String> map) {
		this.map = map;
	}

}
