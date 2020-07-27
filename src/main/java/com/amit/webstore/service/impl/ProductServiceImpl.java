package com.amit.webstore.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.webstore.domain.Product;
import com.amit.webstore.repository.ProductRepository;
import com.amit.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	@Override
	public void updateAllStock() {
		
		List<Product> allProduct = repository.getAllProduct();
		
		for(Product product: allProduct)
		{
			if(product.getUnitsInStock()<500)
			{
				repository.updateStock(product.getProductId(),product.getUnitsInStock()+1000);
			}
		}

	}
	@Override
	public List<Product> getAllProduct() {
		
		return repository.getAllProduct();
	}
	@Override
	public List<Product> getProductByCategory(String category) {
		return repository.getProductByCategory(category);
	}
	@Override
	public List<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		
		return repository.getProductByFilter(filterParams);
	}
	@Override
	public Product getProductById(String id) {
		
		return repository.getProductById(id);
	}
	@Override
	public void addProduct(Product product) {
		repository.addProduct(product);
	}

	
}
