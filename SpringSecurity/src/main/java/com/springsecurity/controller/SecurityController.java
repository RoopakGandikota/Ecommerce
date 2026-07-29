package com.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.model.Students;
import com.springsecurity.service.MyUserDetailsService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SecurityController {
	
	@Autowired
	MyUserDetailsService userservice;
	
	@GetMapping("/demo")
	public String demo(HttpServletRequest http) {
		System.out.println(http.getSession().getId());
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
	
	@GetMapping("/otp")
	public ResponseEntity<Integer> getOTP(@RequestParam() String username,@RequestParam String password) {
		int otp = 0;
		System.out.println("User Service is "+username);
		UserDetails userDtls = userservice.loadUserByUsername(username);
		if(password.equals(userDtls.getPassword())) {
			otp=userservice.getOTP();
			userservice.sendEmail(userDtls.getUsername());
		}
		if(otp==0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(otp, HttpStatus.OK);
	}
	/* Old method to get otp from the user logged in.		
	@GetMapping("/otp")
	public int getOTP() {
		int otp = userservice.getOTP();
		System.out.println("User Service is "+username);
		userservice.sendEmail(userservice.getUserId());
		return otp;
	}*/
	@GetMapping("/validateOTP")
	public ResponseEntity<String> validateOTP(@RequestParam int otp) {
		System.out.println("User Entered OTP is :"+otp);
		boolean validateOtp = userservice.validateOtp(otp);
		return new ResponseEntity<>(validateOtp?"Successful":"Incorrect OTP",HttpStatus.OK);
	}
}
