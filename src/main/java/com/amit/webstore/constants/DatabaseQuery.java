package com.amit.webstore.constants;

public class DatabaseQuery {

	public static final String GET_ALL_PRODUCT = "SELECT * FROM PRODUCTS";
	
	public static final String UPDATE_STOCK = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE  ID = :id";
			
	public static final String FILTER_BY_CATEGORY="SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
	
	public static final String FILTER_BY_CATEGORY_MANFACTURER ="SELECT * FROM PRODUCTS WHERE CATEGORY IN( :categories ) AND MANUFACTURER IN( :brand )";
	
	public static final String FILTER_BY_PRICE="SELECT * FROM PRODUCTS WHERE PRICE BETWEEN :min AND :max";
	
	public static final String FILTER_BY_ID="SELECT * FROM PRODUCTS WHERE ID = :productID";
}
