package com.amit.webstore.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amit.webstore.domain.Product;
import com.amit.webstore.exception.NoProductFoundUnderCategoryException;
import com.amit.webstore.exception.ProductNotFoundException;
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
		//model.addAttribute("products", productService.getProductByCategory(productCategory));
		List<Product> products = productService.getProductByCategory(productCategory);
		
		if(products==null || products.isEmpty())
		{
			throw new NoProductFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
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
		
		return "product";
	}
	
	
	@RequestMapping(value="/products/add", method = RequestMethod.GET )
	public String getAddNewProductForm(Model model)
	{
	Product product = new Product("P1245","EarPhone",new BigDecimal(10));
		model.addAttribute("newProduct", product);
		return "addProduct";
	}
	
	@RequestMapping("/invalid/promocode")
	public String invalidPromoCode()
	{
		return "invalidPromoCode";
	}
	
	@RequestMapping(value="/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProducts")Product product,BindingResult result, HttpServletRequest request)
	{
		String suppressedFields[] = result.getSuppressedFields();
		if (suppressedFields.length > 0) { 
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields)); 
			}
		MultipartFile productImage = product.getProductImage();
		
		String fileName = request.getSession().getServletContext().getRealPath("/")+"resources\\images\\"+product.getProductId()+".jpg";
		
		System.out.println("Product Image: "+productImage);
		if(productImage!=null && !productImage.isEmpty())
		{
			try {
				productImage.transferTo(new File(fileName));
				System.out.println(fileName);
			}
			catch(Exception e) {
				throw new RuntimeException("Product Image Saving failed:"+e);
			}
		}
	
		productService.addProduct(product);
		return "redirect:/products";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder dataBinder)
	{
		dataBinder.setAllowedFields("productId",
				"name",
				"unitPrice",
				"manufacturar",
				"category",
				"unitsInStock",
				"description",
				"condition",
				"productImage");
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException pe)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("invalidProductId", pe.getProductId());
		mv.addObject("exception", pe);
		mv.addObject("url",req.getRequestURL()+"?"+req.getQueryString());
		mv.setViewName("productNotFound");
		return mv;
	}
	
	
}
