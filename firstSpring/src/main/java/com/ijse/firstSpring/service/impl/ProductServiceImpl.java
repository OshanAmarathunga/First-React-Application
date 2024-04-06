package com.ijse.firstSpring.service.impl;

import com.ijse.firstSpring.entity.Product;
import com.ijse.firstSpring.repository.ProductRepository;
import com.ijse.firstSpring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product existingProduct=productRepository.findById(id).orElse(null);
        if (existingProduct==null){
            return null;
        }
            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQty(product.getQty());
            existingProduct.setCategory(product.getCategory());

            return productRepository.save(existingProduct);


    }

    @Override
    public void DeleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
