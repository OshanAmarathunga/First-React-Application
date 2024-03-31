package com.ijse.firstSpring.service;

import com.ijse.firstSpring.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(int id);
    Product createProduct(Product product);
    Product updateProduct(int id,Product product);


}
