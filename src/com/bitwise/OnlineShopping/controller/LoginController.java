package com.bitwise.OnlineShopping.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.OnlineShopping.model.LoginBean;
import com.bitwise.OnlineShopping.model.LoginValidator;





@Controller
@RequestMapping("/")
public class LoginController {
@Autowired
LoginBean login;
@Autowired
LoginValidator loginValidator;

	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) 
    {
         LoginBean loginbean = new LoginBean();
         model.addAttribute("login", loginbean);
         
         return "Login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("login") LoginBean loginbean,
                            BindingResult result ,ModelMap model,HttpServletRequest request, 
                            HttpServletResponse response,HttpSession session) 
    {
    	
       String username=loginbean.getUsername();
       String password=loginbean.getPassword();
       String url="";
    
      loginValidator.validate(login, result);
      
      
      if(!result.hasErrors()){
    	   if(username.equals("Shubham") && password.equals("12345")){
    		   model.addAttribute("login", loginbean);
    		   url="redirect:/success";
    		    session = request.getSession(true);
    			
    			session.setAttribute("username", username);
    			session.setAttribute("sessID", session.getId());
    			session.setMaxInactiveInterval(1000);  		   
    	   }
    	   else{
    		   model.addAttribute("error", "Invalid User !!!! Please Enter Correct Username Or Password");
    		   url="Login";
    	   }
      }
     else
    	   url="Login";
        return url;
    }
     
   @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView success(Model model) 
    {
	   System.out.println("in success");    	
        return new ModelAndView("redirect:/productList");
    }
}
