package com.bitwise.OnlineShopping.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return LoginBean.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		System.out.println("in Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "username is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "password is required.");
        System.out.println("After Validator");
	}
}
