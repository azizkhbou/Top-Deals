package com.esprit.td.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.td.entities.Order;
import com.esprit.td.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/retrieve-all-orders")
	public List<Order> getOrders(){
		List<Order> list = orderService.retrieveAllOrders();
		return list;	}

	@PostMapping("/add-order")
	@ResponseBody
	public Order addOrder(@RequestBody Order o) {
		Order order = orderService.addOrder(o);
		return order;
	}
	
	@DeleteMapping("/remove-order/{order-id}")
    @ResponseBody
	public void removeOrder(@PathVariable("order-id") long idOrder) {
		orderService.deleteOrder(idOrder);
	}
	
	@PutMapping("/modify-order")
    @ResponseBody
	public Order modifyOrder(@RequestBody Order o) {
	return orderService.updateOrder(o);
	}
	
}
