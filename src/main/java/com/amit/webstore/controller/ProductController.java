package com.amit.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amit.webstore.domain.Product;
import com.amit.webstore.service.ProductService;

@Controller
public class ProductController {

		
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String list(Model model)
	{	
		model.addAttribute("products",productService.getAllProduct());
		return "products";
	}
	
	@RequestMapping("/update/stock")
	public String update(Model model)
	{
		productService.updateAllStock();
		return "redirect:/products";
	}
	
	@RequestMapping("/products/{category}")
	public String getProductByCategory(Model model, 
			@PathVariable("category") String productCategory)
	{
		model.addAttribute("products", productService.getProductByCategory(productCategory));
		return "products";
	}
	
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model)
	{
		System.out.println(filterParams);
		model.addAttribute("products", productService.getProductByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String id, Model model)
	{
		model.addAttribute("product", productService.getProductById(id));
		Product pro = productService.getProductById(id);
		System.out.println(pro);
		return "product";
	}
	
	
}
