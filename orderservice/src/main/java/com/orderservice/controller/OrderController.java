package com.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.ExternalServices.ProductServiceIntf;
import com.orderservice.model.Orders;
import com.orderservice.service.ServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private ProductServiceIntf productServiceInft;
	
	@Autowired
	private ServiceImpl objServiceImpl;
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Orders> > getAllOrders() {
		
		List<Orders> lst= objServiceImpl.getAllOrders();
		
		return ResponseEntity.ok(lst);
		//return "Hello from Orders, working on controller ";
	}
	
	//public List<Orders> 
	
	@GetMapping("/getOrdersById/{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable("id") int id){
		Orders obj= objServiceImpl.getOrderById(id);
		return ResponseEntity.ok(obj);
	}
}
