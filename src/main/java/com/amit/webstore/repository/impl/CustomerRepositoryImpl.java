package com.amit.webstore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amit.webstore.domain.Customer;
import com.amit.webstore.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = new ArrayList<>();
		Customer customer = new Customer("101","Amit","New Delhi",11);
		Customer customer2 = new Customer("102","Ankit","Dwarka",17);
		Customer customer3 = new Customer("103","Lata","Rohini",13);
		list.add(customer);
		list.add(customer2);
		list.add(customer3);
		return list;
	}

}
