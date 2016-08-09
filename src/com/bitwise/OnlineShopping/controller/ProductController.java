package com.bitwise.OnlineShopping.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.OnlineShopping.model.CartOperations;
import com.bitwise.OnlineShopping.model.ProductInfo;
import com.bitwise.OnlineShopping.model.Products;

@Controller
public class ProductController {
	
	
	CartOperations cartOperations=new CartOperations();
	
	
	@RequestMapping(value="/productList",method=RequestMethod.GET)
	public ModelAndView showProducts(Model model,@ModelAttribute("products") Products productsbean,
            BindingResult result) {
		Products products = new Products();
		ModelAndView mv = new ModelAndView("Products");
		mv.addObject("products", products);
		Map<String, ProductInfo> mapcontroller=products.getMap1();
		 model.addAttribute("map1",mapcontroller);
		 model.addAttribute("list",products.getList());
		return mv;
		
	}
	
	@RequestMapping(value="/addtoCart",method=RequestMethod.POST)
	public String addToCart(Model model,Products products,
            BindingResult result){
		System.out.println("in post of product controller add to cart");
		model.addAttribute("list",products.getList());
		cartOperations.addToCart(products.getList());
		Map<String, ProductInfo> mapcart=cartOperations.getCartmap();
		model.addAttribute("map",mapcart);
		model.addAttribute("list", products.getList());
		return "DisplayProducts";
	}
	
	@RequestMapping(value="/deleteFromCart" ,method=RequestMethod.POST)
	public String againAddtoCart(Model model,Products products,
            BindingResult result)
	{	
		model.addAttribute("list",products.getList());
		cartOperations.deleteFromCart(products.getList());
		Map<String, ProductInfo> mapcart1=cartOperations.getCartmap();
		model.addAttribute("map",mapcart1);
		model.addAttribute("list", products.getList());
		return "DisplayProducts";
	}
	/*@RequestMapping(value="viewCart",method=RequestMethod.POST)
	public String viewCart(Model model,Products products,
            BindingResult result)
	{
		model.addAttribute("list",products.getList());
		Map<String, ProductInfo> mapcart1=cartOperations.getCartmap();
		model.addAttribute("map",mapcart1);
		return "DisplayProducts";
	}
	*/
/*	@RequestMapping(value="/displayCart",method=RequestMethod.POST)
	public String displayProducts(Model model,Products products,
            BindingResult result){
		System.out.println("in post of product controller displayCart");		
		
		model.addAttribute("map", cartOperations.getCartmap());
		return "DisplayProducts";
	}

	@RequestMapping(value="deleteFromCart", method=RequestMethod.POST)
	public String DeleteProducts(Model model,Products products,
            BindingResult result)
	{
		cartOperations.deleteFromCart(products.getList());
		model.addAttribute("map",cartOperations.getCartmap());
		return "DisplayProducts";
	}*/
}