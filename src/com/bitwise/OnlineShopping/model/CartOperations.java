package com.bitwise.OnlineShopping.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartOperations {
	private Map<String, ProductInfo> cartmap=new HashMap<>();
	Products cartproduct=new Products();
	ProductInfo productinfo;
	public Map<String, ProductInfo> getCartmap() {
		return cartmap;
	}

	public void setCartmap(Map<String, ProductInfo> cartmap) {
		this.cartmap = cartmap;
	}
	
	public void  addToCart(List<String> list) {
		String key;
		System.out.println("In add to cart method of cart Operation");
		for(int i=0;i<list.size();i++){
			key=list.get(i);
			productinfo=cartproduct.map1.get(key);
			if(productinfo.getStock()==0)
				System.out.println("Out of Stock");
			if(productinfo.getQuantity()==1&&productinfo.getStock()!=0){
				cartmap.put(key,productinfo);
				productinfo.setQuantity(productinfo.getQuantity()+1);
				productinfo.setStock(productinfo.getStock()-1);
			}
			else{
				productinfo.setQuantity(productinfo.getQuantity()+1);
				cartmap.remove(key);
				
				cartmap.put(key, new ProductInfo(productinfo.getName(), productinfo.getPrice(), productinfo.getColor(), productinfo.getSize(), productinfo.getQuantity(),productinfo.getStock()));
			}
			
		}
	}

	public void deleteFromCart(List<String> list) {
		String key;
		System.out.println("in delete from Cart");
		for(int i=0;i<list.size();i++)
		{
			System.out.println("");
			key=list.get(i);
			cartmap.remove(key);
		}
	}
	
}
