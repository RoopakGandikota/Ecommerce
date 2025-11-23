package com.orderservice.ExternalServices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderservice.model.Product;


@FeignClient("productservice")
public interface ProductServiceIntf {
	
	@GetMapping("product")
    public String helper();
	
	@GetMapping("product/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id);
	
	 @GetMapping("product/getProducts")
	  public List<Product> getAllProducts();
}
