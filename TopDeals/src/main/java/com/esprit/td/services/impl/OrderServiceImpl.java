package com.esprit.td.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.td.entities.Order;
import com.esprit.td.repositories.OrderRepository;
import com.esprit.td.services.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> retrieveAllOrders() {
		return (List<Order>) (orderRepository.findAll());

	}

	@Override
	public Order addOrder(Order o) {
		orderRepository.save(o);
		return o;
	}

	@Override
	public void deleteOrder(long idOrder) {
		orderRepository.deleteById(idOrder);
		
	}

	@Override
	public Order updateOrder(Order o) {
		orderRepository.save(o);
		return o;
	}
	

}
