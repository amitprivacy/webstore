package com.amit.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.webstore.domain.Order;
import com.amit.webstore.repository.OrderRepository;
import com.amit.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired 
    private OrderRepository orderRepository; 

    @Override 
    public Long saveOrder(Order order) { 
       return orderRepository.saveOrder(order); 
    } 
}
