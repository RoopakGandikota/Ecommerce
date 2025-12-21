package com.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.model.User;

public interface UserRepo  extends JpaRepository<User, Integer>{
	User findUserByUsername(String username);
}
