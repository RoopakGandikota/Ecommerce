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
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<Integer> getProductList() {
		return productList;
	}
	public void setProductList(List<Integer> productList) {
		this.productList = productList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Orders( int userid, List<Integer> productList, String status, Date createAt, Date updatedAt) {
		super();
		//this.orderid = orderid;
		this.userid = userid;
		this.productList = productList;
		this.status = status;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
