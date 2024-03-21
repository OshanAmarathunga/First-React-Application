package com.ijse.firstSpring.controller;

import com.ijse.firstSpring.dto.ProductDto;
import com.ijse.firstSpring.entity.Category;
import com.ijse.firstSpring.entity.Product;
import com.ijse.firstSpring.service.CategoryService;
import com.ijse.firstSpring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProct(){
       List<Product> getAllproducts=productService.getAllProducts();
       return getAllproducts==null?ResponseEntity.status(404).build():ResponseEntity.status(200).body(getAllproducts);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product=productService.getProduct(id); // validation
        if(product==null){
            return ResponseEntity.status(404).build();
        }else {
            return ResponseEntity.status(200).body(product);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto dto){
        Product productEntity=new Product();
        productEntity.setProductName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        productEntity.setQty(dto.getQuantity());

        Category category =categoryService.getCategory(dto.getCategoryId());
        productEntity.setCategory(category);

        Product savedProduct=productService.createProduct(productEntity);
        if(savedProduct==null){
            return ResponseEntity.status(404).build();
        }else {
            return ResponseEntity.status(201).body(savedProduct);
        }
    }



}
