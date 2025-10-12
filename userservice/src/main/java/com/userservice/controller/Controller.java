package com.userservice.controller;


import com.userservice.model.User;
import com.userservice.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class Controller {
    @GetMapping("")
    public String demo(){
        return "Welcome to the user page";
    }

    @Autowired
    UserService service;



    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        System.out.println("Written by deepak");
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("getUserBYId/{id}")
    public ResponseEntity<User> getUserBYId(@PathVariable int id){
        return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
    }

    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return new ResponseEntity<>(service.deleteUserById(id),HttpStatus.OK);
    }

    @PutMapping("updateById/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id,@RequestBody User user){
        return new ResponseEntity<>(service.updateUserById(id,user),HttpStatus.OK);
    }
}

