package com.amit.webstore.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amit.webstore.domain.CartItem;
import com.amit.webstore.service.ProductService;

public class CartItemMapper implements RowMapper<CartItem> {

	ProductService productService;
	public CartItemMapper(ProductService productService)
	{
		this.productService = productService;
	}
	@Override
	public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CartItem cartItem = new CartItem(rs.getString("ID"));
		
		cartItem.setProduct(productService.getProductById(rs.getString("PRODUCT_ID")));
		cartItem.setQuantity(rs.getInt("QUANTITY"));
		return cartItem;
	}
	
	

}
