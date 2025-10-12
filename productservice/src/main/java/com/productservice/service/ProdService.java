package com.productservice.service;

import com.productservice.model.Product;

import java.util.List;

public interface ProdService {

    List<Product> getAllProducts();
    Product getProductsById(int id);

    String addProduct(Product prod);

    String delProductByid(int id);

    String updateProductById(int id,Product prod);
}
