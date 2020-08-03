package com.amit.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amit.webstore.domain.Product;
import com.amit.webstore.exception.ProductNotFoundException;
import com.amit.webstore.service.ProductService;

@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String>{

	
	@Autowired
	ProductService productService;
	@Override
	public void initialize(ProductId constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Product product;
		
		try {
			product=productService.getProductById(value);
		}
		catch(ProductNotFoundException e)
		{
			return true;
		}
		if(product!=null)
		{
			return false;
		}
		return true;
	}

}
