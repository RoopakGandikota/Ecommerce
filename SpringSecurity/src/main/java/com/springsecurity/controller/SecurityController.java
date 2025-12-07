package com.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Namespace;

import org.springframework.http.MediaType;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.model.Students;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class SecurityController {
	
	@GetMapping("/demo")
	public String demo(HttpServletRequest http) {
		return "Hii!!!... Welcome to the Spring Security Module..." +http.getSession().getId();
		
	}
	
	private List<Students> names= new ArrayList<>( List.of(new Students(1,"Roopak"),new Students(2,"Deepak"),new Students(3,"Lavanya")));
	
	@GetMapping("/csrf")
	public String getCsrfId(HttpServletRequest http) {
		CsrfToken token=(CsrfToken) http.getAttribute("_csrf");
		return token.getToken();
	}
	
	@PostMapping(value="/update")
	public List<Students> updateNames(@RequestBody Students st) {
		 names.add(st);
		 return names;
	}

	@GetMapping("/all")
	public List<Students> getAll(){
		return names;
	}
}
