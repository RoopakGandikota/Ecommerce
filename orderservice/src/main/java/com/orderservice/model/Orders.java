package com.orderservice.model;

import java.util.Date;
import java.util.List;

import com.orderservice.model.Interface.ProductIntf;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private int userid;
	@Transient
	private List<Integer> productList; //storing product id's to fetch.
	private String status;
	private Date createAt;
	private Date updatedAt;
}
