package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.ExternalServices.ProductServiceIntf;
import com.orderservice.model.Orders;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private ProductServiceIntf productServiceInft;

	
	@GetMapping("/demo")
	public String getAllOrders() {
		
		return productServiceInft.helper();
		//return "Hello from Orders, working on controller ";
	}
	
	@GetMapping("/getUserById")
	public ResponseEntity<Orders> getOrderById(){
		Orders obj=new Orders();
		return ResponseEntity.ok(obj);
	}
}
