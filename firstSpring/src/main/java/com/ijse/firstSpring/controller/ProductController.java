package com.ijse.firstSpring.controller;

import com.ijse.firstSpring.entity.Product;
import com.ijse.firstSpring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProct(){
       List<Product> getAllproducts=productService.getAllProducts();
       return getAllproducts==null?ResponseEntity.status(404).build():ResponseEntity.status(200).body(getAllproducts);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product=productService.getProduct(id);
        if(product==null){
            return ResponseEntity.status(404).build();
        }else {
            return ResponseEntity.status(200).body(product);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> creareProduct(@RequestBody Product product){
        Product savedProduct=productService.createProduct(product);
        if(product==null){
            return ResponseEntity.status(404).build();
        }else {
            return ResponseEntity.status(201).body(product);
        }
    }



}
