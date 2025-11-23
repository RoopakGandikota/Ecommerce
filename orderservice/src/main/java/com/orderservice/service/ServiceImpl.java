package com.orderservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.orderservice.ExternalServices.ProductServiceIntf;
import com.orderservice.model.Orders;
import com.orderservice.model.Product;
import com.orderservice.repo.OrderRepo;

import jakarta.annotation.PostConstruct;


@Service
public class ServiceImpl implements OrderServiceIntf{
	
	@Autowired
	private ProductServiceIntf productServiceIntf;
	
	@Autowired
	private OrderRepo repo;
	
//	public String demo() {
//		return productServiceIntf.helper();
//		//return ;
//	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		List<Orders> all = repo.findAll();
		//all.get(0).getProductList().add(1);
		return all;
	}
	
	@PostConstruct
    public void creatingDemoDB() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date crdate = sdf.parse("12-11-2025");
		Date update= sdf.parse("13-11-2025");
		
		List<Product> lst=productServiceIntf.getAllProducts();
		List<Integer> ilst=new ArrayList<>();
		for(Product p: lst) {
			ilst.add(p.getId());
		}
		ilst.add(1);
		repo.save(new Orders(1,ilst,"Placed",crdate,update));
		
	}

	@Override
	public Orders getOrderById(int id) {
		// TODO Auto-generated method stub
		Optional<Orders> order=repo.findById(id);
		productServiceIntf.getProductById(1);  //hard coded id.
		Orders obj =order.get();
		obj.setProductList(obj.getProductList());
		//return repo.findById(id).get();
		return obj;
	}

	@Override
	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateOrderById(int id, Orders order) {
		// TODO Auto-generated method stub
		return null;
	}
}
