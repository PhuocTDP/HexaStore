package com.store.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.store.entity.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

	List<Order> findAll();
	
	List<Order> findAllDESC();

	public void delete(Long id);

	public Order update(Order order);

}
