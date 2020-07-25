package com.amit.webstore.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.amit.webstore")
public class RootApplicationContextConfig {
	
	@Bean
	public DataSource dataSource() {
	DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/webstore");
		ds.setPassword("root");
		ds.setUsername("root");
		return ds;
	
	}
	
	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate()
	{
		return new NamedParameterJdbcTemplate(dataSource());
	}
}
