package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Order;

public interface OrderService {
	List<Order> retrieveAllOrders();
	Order addOrder(Order o);
	void deleteOrder(long idOrder);
	Order updateOrder(Order o);

}
