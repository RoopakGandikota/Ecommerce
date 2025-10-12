package com.userservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "productservice")
public interface ProdControllerInterface {

	@GetMapping("/product")
    public String helper();
	
}
	