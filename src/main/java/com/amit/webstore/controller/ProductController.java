package com.amit.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amit.webstore.repository.ProductRepository;
import com.amit.webstore.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String list(Model model)
	{	
		model.addAttribute("product",productRepository.getAllProduct());
		return "products";
	}
	
	@RequestMapping("/update/stock")
	public String update(Model model)
	{
		productService.updateAllStock();
		return "redirect:/products";
	}
	
	
	
	}
