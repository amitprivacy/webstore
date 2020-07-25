package com.amit.webstore.service.impl;

import java.util.List;

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

}
