package com.bitwise.OnlineShopping.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.OnlineShopping.model.CartOperations;
import com.bitwise.OnlineShopping.model.ProductInfo;
import com.bitwise.OnlineShopping.model.Products;

@Controller
public class ProductController {
	
	@Autowired
	CartOperations cartOperations;
	
	
	@RequestMapping(value="/productList",method=RequestMethod.GET)
	public ModelAndView showProducts(Model model,@ModelAttribute("products") Products productsbean,
            BindingResult result,HttpServletRequest request, 
            HttpServletResponse response) {
		
		Products products = new Products();
		
		HttpSession session=request.getSession(false);  
             if(session==null || (session!=null && session.isNew()))
            	 return new ModelAndView("redirect:/");
		@SuppressWarnings("unchecked")
		Map<String, ProductInfo> mapcart=(Map<String, ProductInfo>) products.getMap1();
				session.getAttribute("map");
		products=mapSession(mapcart);
		ModelAndView mv = new ModelAndView("Products");
		mv.addObject("products", products);
		Map<String, ProductInfo> mapcontroller=products.getMap1();
		 model.addAttribute("map1",mapcontroller);
		// model.addAttribute("list",products.getList());
		return mv;
		
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Products mapSession(Map<String, ProductInfo> mapcontroller)
	{
		Products p=new Products();
		if(mapcontroller!=null)
		{
		p.setList(new ArrayList(mapcontroller.keySet()));
		p.setMap1(mapcontroller);
		}
		return p;
	}
	
	@RequestMapping(value="/addtoCart",method=RequestMethod.POST)	
	public String addToCart(Model model,Products products,
            BindingResult result,HttpServletRequest request, 
            HttpServletResponse response)
	{
		HttpSession session=request.getSession(false);  
        if(session==null || (session!=null && session.isNew()))
       	 return ("redirect:/");
		
		System.out.println("in post of product controller add to cart");
		model.addAttribute("list",products.getList());
		cartOperations.addToCart(products.getList());
		
		Map<String, ProductInfo> mapcart=cartOperations.getCartmap();
		model.addAttribute("map",mapcart);
		if(products.getList()==null){
			model.addAttribute("producterror", "Please Select at Least One Detail !!!");
			throw new RuntimeException();
		}
		model.addAttribute("list", products.getList());
		
	    session.setAttribute("map",mapcart); 
	       
		return "DisplayProducts";
	}
	
	
	
	
	@RequestMapping(value="/deleteFromCart" ,method=RequestMethod.POST)
	public String deleteFromcart(Model model,Products products,
            BindingResult result,HttpServletRequest request, 
            HttpServletResponse response)
	{	
		
		HttpSession session=request.getSession(false);
		 if(session==null || (session!=null && session.isNew()))
	       	 return ("redirect:/");
        
		@SuppressWarnings("unchecked")
		Map<String, ProductInfo> mapcart=(Map<String, ProductInfo>) session.getAttribute("map");
		if(products.getList()==null){
			model.addAttribute("producterror", "Please Select at Least One Detail !!!");
			throw new RuntimeException();
		}
		
		model.addAttribute("list",products.getList());
		cartOperations.deleteFromCart(products.getList(),mapcart);
		Map<String, ProductInfo> mapcart1=cartOperations.getCartmap();
		
		session.setAttribute("map",mapcart1);
		
		model.addAttribute("map",mapcart1);
		model.addAttribute("list", products.getList());
		return "DisplayProducts";
	}
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.POST)
	public ModelAndView placeOrder(Model model,Products products,
            BindingResult result,HttpServletRequest request, 
            HttpServletResponse response)
	{
		System.out.println("in place order method");
		HttpSession session=request.getSession(false);
		 Map<String, ProductInfo> mapcart2=(Map<String, ProductInfo>) session.getAttribute("map");
		 //checking for map
		 
		 Iterator it = mapcart2.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println("key is in Product Controller "+pair.getKey() + " value is = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    
		 double sum=cartOperations.placeOrder(mapcart2);
		 System.out.println("in controller of place order "+sum);
		 model.addAttribute("sum",sum);
		return new ModelAndView("OrderHistory", "sum", sum);
	}
	
	@RequestMapping(value="/Logout",method=RequestMethod.POST)
	public String LogOutSession(Model model,BindingResult result,HttpServletRequest request, 
            HttpServletResponse response){
		
			request.getSession(false).invalidate();
			return "redirect:/";
	}
}