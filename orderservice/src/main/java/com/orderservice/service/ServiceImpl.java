package com.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orderservice.model.OrderService;


@Service
public class ServiceImpl implements OrderServiceIntf{

	@Override
	public List<OrderService> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderService getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addOrder(OrderService order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateOrderById(int id, OrderService order) {
		// TODO Auto-generated method stub
		return null;
	}

}
