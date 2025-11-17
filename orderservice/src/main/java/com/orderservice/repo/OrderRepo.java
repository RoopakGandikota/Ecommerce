package com.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.OrderService;


@Repository
public interface OrderRepo extends JpaRepository<OrderService, Integer>{

}
