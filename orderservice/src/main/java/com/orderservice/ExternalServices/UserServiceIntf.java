package com.orderservice.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("userservice")
public interface UserServiceIntf {

}
