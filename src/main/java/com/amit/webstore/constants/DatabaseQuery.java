package com.amit.webstore.constants;

public class DatabaseQuery {

	public static final String GET_ALL_PRODUCT = "SELECT * FROM PRODUCTS";
	
	public static final String UPDATE_STOCK = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE  ID = :id";
			
	public static final String FILTER_BY_CATEGORY="SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
	
	public static final String FILTER_BY_CATEGORY_MANFACTURER ="SELECT * FROM PRODUCTS WHERE CATEGORY IN( :categories ) AND MANUFACTURER IN( :brand )";
	
	public static final String FILTER_BY_PRICE="SELECT * FROM PRODUCTS WHERE PRICE BETWEEN :min AND :max";
	
	public static final String FILTER_BY_ID="SELECT * FROM PRODUCTS WHERE ID = :productID";
	
	public static final String INSERT_PRODUCT_IN_DB="INSERT INTO PRODUCTS(ID,NAME,DESCRIPTION,UNIT_PRICE,MANUFACTURER,CATEGORY,CONDITIONS,UNITS_IN_STOCK,UNITS_IN_ORDER,DISCONTINUED)"
			+ "VALUES(:id,:name, :desc, :price, :manufacturer, :category,:condition,:instock,:inorder,:discontinued)";
}
