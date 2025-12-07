package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/demo")
	public String demo() {
		return "Hii!!!... Welcome to the Spring Security Module...";
	}
}
