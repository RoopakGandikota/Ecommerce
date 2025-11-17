package com.orderservice.service;

import java.util.List;

import com.orderservice.model.OrderService;

public interface OrderServiceIntf {

	List<OrderService> getAllOrders();
	OrderService getOrderById(int id);
	String addOrder(OrderService order);
	String delOrderById(int id);
	String updateOrderById(int id, OrderService order);
}
