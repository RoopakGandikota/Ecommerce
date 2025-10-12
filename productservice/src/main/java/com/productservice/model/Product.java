package com.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String desc;
    private int quantity;
    private double price;
    private LocalDate MFD;
    private String category;

    
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public LocalDate getMFD() {
		return MFD;
	}



	public void setMFD(LocalDate mFD) {
		MFD = mFD;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product(int id, String name, String desc, int quantity, double price, LocalDate mFD, String category) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.quantity = quantity;
		this.price = price;
		MFD = mFD;
		this.category = category;
	}

	public Product(String name, String desc, int quantity, double price, LocalDate MFD, String category) {
        this.name=name;
        this.desc=desc;
        this.quantity=quantity;
        this.price=price;
        this.MFD=MFD;
        this.category=category;
    }
    
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", quantity=" + quantity + ", price=" + price
				+ ", MFD=" + MFD + ", category=" + category + "]";
	}
    
}
