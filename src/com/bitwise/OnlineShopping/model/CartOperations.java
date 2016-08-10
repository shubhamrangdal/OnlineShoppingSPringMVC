package com.bitwise.OnlineShopping.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
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
			if(productinfo.getStock()==0){
		    		throw new RuntimeException();
			}
			else{
//				cartmap.put(key,productinfo);
				productinfo.setQuantity(productinfo.getQuantity()+1);
				productinfo.setStock(productinfo.getStock()-1);
				productinfo.setPrice(productinfo.getQuantity()*productinfo.getPrice());
			
//				productinfo.setQuantity(productinfo.getQuantity()+1);
				cartmap.remove(key);
				cartmap.put(key, new ProductInfo(productinfo.getName(), productinfo.getPrice(), productinfo.getColor(), productinfo.getSize(), productinfo.getQuantity(),productinfo.getStock()));
			}
			
		}	}

	public Map<String, ProductInfo> deleteFromCart(List<String> list, Map<String, ProductInfo> mapcart) {
		String key;
		System.out.println("in delete from Cart");
		for(int i=0;i<list.size();i++)
		{
			System.out.println("");
			key=list.get(i);
			
			String [] st=key.split("=");
			System.out.println(st[0]);
			productinfo=mapcart.get(key);
			if(productinfo.getQuantity()==1)
				mapcart.remove(st[0]);
			else{
				productinfo.setStock(productinfo.getStock()+1);
				productinfo.setQuantity(productinfo.getQuantity()-1);
				mapcart.put(st[0], new ProductInfo(productinfo.getName(), productinfo.getPrice(), productinfo.getColor(), productinfo.getSize(), productinfo.getQuantity(),productinfo.getStock()));
			}
			mapcart.remove(st[0]);
		}
		return mapcart;
	}

	public double placeOrder(Map<String, ProductInfo> mapcart) {
		double sum=0.0;
		int i=0;
		String key[] = null;
		ProductInfo product []=new ProductInfo[mapcart.size()];
		System.out.println("in place order");
		System.out.println("map size is "+mapcart.size());
		Iterator it = mapcart.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println("key is in cart Operations "+pair.getKey() + " = " + pair.getValue());
	        key[i++]=(String) pair.getKey();
	        product[i++]=(ProductInfo) pair.getValue();
	        it.remove(); 
	    }
	    System.out.println("in place order  size is"+mapcart.size());
		for (int j=0;j<mapcart.size();j++)
		{
			System.out.println("in for of place order price of "+key[i]+" is ");
			sum=sum+mapcart.get(key[i]).getPrice();
			System.out.println(sum+"in place order");
		}
		System.out.println(sum);
		return sum;
		
	}
	
}
