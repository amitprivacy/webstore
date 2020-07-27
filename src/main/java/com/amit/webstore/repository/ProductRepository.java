package com.amit.webstore.repository;

import java.util.List;
import java.util.Map;

import com.amit.webstore.domain.Product;

public interface ProductRepository {

	List<Product> getAllProduct();
	
	void updateStock(String productId, long noOfUnits);
	
	List<Product> getProductByCategory(String category);
	
	List<Product> getProductByFilter(Map<String, List<String>> filterParams);
	
	Product getProductById(String productId);
	
	void addProduct(Product product);
	
}
