package com.ijse.firstSpring.controller;

import com.ijse.firstSpring.entity.Category;
import com.ijse.firstSpring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
}
