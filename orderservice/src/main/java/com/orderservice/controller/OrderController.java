package com.orderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.model.Orders;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("/demo")
	public String getAllOrders() {
		return "Hello from Orders";
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Orders> getOrderById(){
		Orders obj=new Orders();
		
		return ResponseEntity.ok(obj);
	}
}
