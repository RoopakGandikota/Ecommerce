package com.productservice.service;
import com.productservice.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.productservice.repo.Repo;
import com.productservice.userController.UserControllerIntf;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ProdService{

    @Autowired
    private Repo repo;
    
    @Autowired
    private UserControllerIntf objUserFeignClient;
    
    @Override
    public List<Product> getAllProducts() {
    	System.out.println(objUserFeignClient.demo());
        return repo.findAll();
    }

    @Override
    public Product getProductsById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String addProduct(Product prod) {
        repo.save(prod);
        return "Product added successfully";
    }

    @Override
    public String delProductByid(int id) {
        repo.deleteById(id);
        return "Product deleted successfully";
    }


    @PostConstruct
    public void creatingDemoDB(){
        repo.save(new Product("Samaung-S9 Fe+","latest samsung tablet with ultra wide display and 10090mAH huge batter and solid performance,comes with s-pen included in it",50,31999.0, LocalDate.parse("2025-02-10"),"Electronics"));
        repo.save(new Product("Apple i-pad","latest Ios tablet with M4 chip, with robost features ,build on IOS software. An Apple product",20,35999.0, LocalDate.parse("2025-05-10"),"Electronics"));
    }


    public String deleteById(int id){
        repo.deleteById(id);
        return "success";
    }

    @Override
    public String updateProductById(int id, Product prod) {

        Optional<Product> oldProd=repo.findById(id);
//        if(oldProd.isEmpty()){
//            return "Product Not found.";
//        }
        if(oldProd.isPresent()) {
            Product oldP = oldProd.get();
            //oldP.setId(prod.getId());
            oldP.setName(prod.getName());
            oldP.setDesc(prod.getDesc());
            oldP.setMFD(prod.getMFD());
            oldP.setPrice(prod.getPrice());
            oldP.setCategory(prod.getCategory());
            oldP.setQuantity(prod.getQuantity());
            repo.save(oldP);
            return "Product updated successfully";
        }
        return "Product not found";
    }


}
