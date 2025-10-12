package com.productservice.controller;

import com.productservice.model.Product;
import com.productservice.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping("")
    public String helper(){
        return " hii this is product service";
    }

    @Autowired
    private ProdService service;


    @GetMapping("getProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        try{
            service.getProductsById(id);
        }catch (Exception e){
            //e.getMessage();
            return new ResponseEntity<>(service.getProductsById(id),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getProductsById(id),HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(Product prod){
        String res;
        try{
            res=service.addProduct(prod);
        }catch (Exception e){
            return new ResponseEntity<>("Attributes miss match",HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        try{
            service.delProductByid(id);
        }catch (Exception e){
            return new ResponseEntity<>("Product ID not found, Please give valid Product Id",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.delProductByid(id),HttpStatus.OK);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable  int id, @RequestBody Product prod){
        String res;
        try{
            res=service.updateProductById(id,prod);
        }catch (Exception e){
            return new ResponseEntity<>("Product ID not found, Please give valid Product Id",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
