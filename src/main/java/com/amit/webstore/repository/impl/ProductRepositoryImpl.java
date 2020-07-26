package com.amit.webstore.repository.impl;

import static com.amit.webstore.constants.DatabaseQuery.GET_ALL_PRODUCT;
import static com.amit.webstore.constants.DatabaseQuery.UPDATE_STOCK;
import static com.amit.webstore.constants.DatabaseQuery.FILTER_BY_CATEGORY;
import static com.amit.webstore.constants.DatabaseQuery.FILTER_BY_CATEGORY_MANFACTURER;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amit.webstore.domain.Product;
import com.amit.webstore.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Product> getAllProduct() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<Product> result = jdbcTemplate.query(GET_ALL_PRODUCT, params, new ProductMapper());
		return result;
	}
	
	private static final class ProductMapper implements RowMapper<Product>
	{
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Product product = new Product();
			product.setProductId(rs.getString("ID")); 
            product.setName(rs.getString("NAME")); 
            product.setDescription(rs.getString("DESCRIPTION")); 
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE")); 
            product.setManufacturar(rs.getString("MANUFACTURER")); 
            product.setCategory(rs.getString("CATEGORY")); 
            product.setCondition(rs.getString("CONDITIONs")); 
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK")); 
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER")); 
            product.setDisconinued(rs.getBoolean("DISCONTINUED")); 
			
			return product;
		}
	}

	@Override
	public void updateStock(String productId, long noOfUnits) {
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("unitsInStock",noOfUnits);
		params.put("id",productId);
		
		jdbcTemplate.update(UPDATE_STOCK, params);
		
		
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category);
		return jdbcTemplate.query(FILTER_BY_CATEGORY,params,new ProductMapper());
	}

	@Override
	public List<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		
		return jdbcTemplate.query(FILTER_BY_CATEGORY_MANFACTURER, filterParams, new ProductMapper());
	}

}
