package com.orderservice.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.Orders;
import com.orderservice.model.Product;



@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{
 
}
