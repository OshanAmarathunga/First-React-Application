package com.ijse.firstSpring.service;

import com.ijse.firstSpring.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    List<Category> getAllCategory();
    Category getCategory(int id);
    Category createCategory(Category category);
}
