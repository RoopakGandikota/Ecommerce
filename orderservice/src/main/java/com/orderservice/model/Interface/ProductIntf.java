package com.orderservice.model.Interface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderservice.model.Product;


public interface ProductIntf {

	@GetMapping("getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id);
}
