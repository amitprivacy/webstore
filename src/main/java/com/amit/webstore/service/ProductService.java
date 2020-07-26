package com.amit.webstore.service;

import java.util.List;
import java.util.Map;

import com.amit.webstore.domain.Product;

public interface ProductService {

	void updateAllStock();
	
	List<Product> getAllProduct();
	
	List<Product> getProductByCategory(String category);
	
	List<Product> getProductByFilter(Map<String, List<String>> filterParams);
}
