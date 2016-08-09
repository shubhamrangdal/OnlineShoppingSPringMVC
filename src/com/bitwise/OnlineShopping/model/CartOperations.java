package com.bitwise.OnlineShopping.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartOperations {
	private Map<String, Products> cartmap=new HashMap<>();
	Products cartproduct=new Products();
	
	public Map<String, Products> getCartmap() {
		return cartmap;
	}

	public void setCartmap(Map<String, Products> cartmap) {
		this.cartmap = cartmap;
	}
	
	public void  addToCart(List<String> list) {
		
		for(int i=0;i<list.size();i++){
			if(!cartmap.containsKey(list.get(i)));
//				cartmap.put(cartproduct)
		}
	}
	
}
