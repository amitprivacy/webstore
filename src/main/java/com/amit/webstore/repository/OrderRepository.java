package com.amit.webstore.repository;

import com.amit.webstore.domain.Order;

public interface OrderRepository {
	
	long saveOrder(Order order);

}
