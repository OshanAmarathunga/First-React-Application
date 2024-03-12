package com.ijse.firstSpring.repository;

import com.ijse.firstSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>{
}
