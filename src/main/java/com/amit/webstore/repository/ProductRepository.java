package com.amit.webstore.repository;

import java.util.List;

import com.amit.webstore.domain.Product;

public interface ProductRepository {

	List<Product> getAllProduct();
	
	void updateStock(String productId, long noOfUnits);
}
