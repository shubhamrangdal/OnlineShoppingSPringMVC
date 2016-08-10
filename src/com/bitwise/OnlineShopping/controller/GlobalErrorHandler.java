package com.bitwise.OnlineShopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalErrorHandler {
public static final String DEFAULT_ERROR_VIEW = "error";
	
	@ExceptionHandler(value =Throwable.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("globalerror", e);
		mav.addObject("url", request.getRequestURL());
		return mav;
	}
}
