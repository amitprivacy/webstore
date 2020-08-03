package com.amit.webstore.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static com.amit.webstore.constants.DatabaseQuery.GET_CART_ITEMS;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.amit.webstore.domain.Cart;
import com.amit.webstore.domain.CartItem;
import com.amit.webstore.service.ProductService;

public class CartMapper implements RowMapper<Cart> {

	private CartItemMapper cartItemMapper;
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public CartMapper(NamedParameterJdbcTemplate jdbcTemplate, ProductService productService)
	{
		this.jdbcTemplate = jdbcTemplate;
		cartItemMapper = new CartItemMapper(productService);
	}
	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String id = rs.getString("ID");
		
		Cart cart = new Cart(id);
		String SQL = String.format("SELECT * FROM  CART_ITEM WHERE CART_ID = '%s'", id);
		List<CartItem> cartItems = jdbcTemplate.query(SQL,cartItemMapper);
		
		cart.setCartItem(cartItems);
		System.out.println("Cart Items Set.");
		return cart;
	}

}
