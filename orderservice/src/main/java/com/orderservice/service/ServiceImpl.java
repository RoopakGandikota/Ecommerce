package com.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.ExternalServices.ProductServiceIntf;
import com.orderservice.model.Orders;


@Service
public class ServiceImpl implements OrderServiceIntf{
	
	@Autowired
	private ProductServiceIntf productServiceIntf;
	
	public String demo() {
		return productServiceIntf.helper();
		//return ;
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateOrderById(int id, Orders order) {
		// TODO Auto-generated method stub
		return null;
	}
}
