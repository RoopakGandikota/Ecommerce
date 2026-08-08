package com.springsecurity.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.model.User;
import com.springsecurity.model.UserPrincipal;
import com.springsecurity.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	private int otp;
	private String userId;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findUserByUsername(username);
		System.out.println("User Details are"+user.getUsername()+" "+user.getPassword());
		if(user==null) {
			throw new UsernameNotFoundException("User not found......");
		}
		this.userId=user.getUsername();
		return new UserPrincipal(user);
	}
	
	public int getOTP() {
		Random random = new Random();
        int number = 1000 + random.nextInt(9000);
        this.otp=number;
		return number;
	}
	public boolean validateOtp(int num) {
		if(otp==num) {
			otp=0;
			return true;
		}
		return false;
	}
	
	public String getUserId() {
		return userId;
	}

	public void sendEmail(String to) {

	    SimpleMailMessage message = new SimpleMailMessage();

	    message.setTo(to);
	    message.setSubject("OTP Verification");
	    message.setText("OTP: "+otp);

	    mailSender.send(message);
	}
}
