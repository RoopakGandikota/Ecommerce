package com.productservice.userController;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="userservice")
public interface UserControllerIntf {

	 @GetMapping("/User")
	    public String demo();
	
}
