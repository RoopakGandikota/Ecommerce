package com.userservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String email;
    String password;
    String address;
    String phonenumber;
    String role;
    LocalDate createdAt;
    LocalDate updatedAt;

    
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public LocalDate getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDate getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}



	public User(int id, String username, String email, String password, String address, String phonenumber, String role,
			LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String username, String email, String password, String address, String phonenumber, String role, LocalDate createdAt, LocalDate updatedAt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
