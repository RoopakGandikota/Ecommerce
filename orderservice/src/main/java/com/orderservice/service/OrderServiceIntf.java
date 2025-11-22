package com.orderservice.service;

import java.util.List;

import com.orderservice.model.Orders;

public interface OrderServiceIntf {

	List<Orders> getAllOrders();
	Orders getOrderById(int id);
	String addOrder(Orders order);
	String delOrderById(int id);
	String updateOrderById(int id, Orders order);
}
