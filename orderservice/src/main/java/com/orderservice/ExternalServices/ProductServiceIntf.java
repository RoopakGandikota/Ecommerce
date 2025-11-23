package com.orderservice.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("productservice")
public interface ProductServiceIntf {
	
	@GetMapping("product")
    public String helper();
}
