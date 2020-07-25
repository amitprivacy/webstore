package com.amit.webstore.constants;

public class DatabaseQuery {

	public static final String GET_ALL_PRODUCT = "SELECT * FROM PRODUCTS";
	
	public static final String UPDATE_STOCK = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE"
			+ " ID = :id";
}
