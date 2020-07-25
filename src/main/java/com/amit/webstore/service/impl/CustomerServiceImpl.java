package com.amit.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.webstore.domain.Customer;
import com.amit.webstore.repository.CustomerRepository;
import com.amit.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	@Override
	public List<Customer> getAllCustomers() {
		
		return repository.getAllCustomer();
	}

}
