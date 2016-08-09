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

	@RequestMapping(value="/productList",method=RequestMethod.GET)
	public ModelAndView showProducts(Model model,@ModelAttribute("products") Products productsbean,
            BindingResult result,HttpServletRequest request ,HttpServletResponse response) {
		Products products = new Products();
		 HttpServletRequest session=(HttpServletRequest) request.getSession();
		ModelAndView mv = new ModelAndView("Products");
		mv.addObject("products", products);
		Map<String, ProductInfo> mapcontroller=products.getMap1();
		 model.addAttribute("map1",mapcontroller);
		 model.addAttribute("map",products.getMap());
		return mv;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String displayProducts(Model model,Products products,
            BindingResult result){
		System.out.println("in post of product controller");
		CartOperations cartOperations=new CartOperations();
		
		cartOperations.addToCart(products.getMap());
		model.addAttribute("map", products.getMap());
		return "DisplayProducts";
	}
	
}