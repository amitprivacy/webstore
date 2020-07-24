package com.amit.webstore.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amit.webstore.domain.Product;

@Controller
public class ProductController {

	@RequestMapping("/products")
	public String list(Model model)
	{
		Product iphone = new Product("P1234","iPhone 6s",new BigDecimal(500));
		iphone.setDescription("Applie iPhone 6s smart phone with 4.00-inch 640x1136 display and 8-megapixel rear Camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturar("Apple");
		iphone.setUnitsInStock(1000);
		
		model.addAttribute("product",iphone);
		return "products";
	}
}
