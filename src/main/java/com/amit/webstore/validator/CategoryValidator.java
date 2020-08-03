package com.amit.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amit.webstore.service.ProductService;

@Component
public class CategoryValidator implements ConstraintValidator<Category,String> {

	@Autowired
	ProductService productService;
	
	List<String> allowedCategory=null;
	
	CategoryValidator(){
		allowedCategory = new ArrayList<>();
		allowedCategory.add("Earphone");
		allowedCategory.add("SmartPhone");
		allowedCategory.add("Laptop");
	}
	@Override
	public void initialize(Category constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(!allowedCategory.contains(value))
		{
			return false;
		}
		return true;
	}

}
