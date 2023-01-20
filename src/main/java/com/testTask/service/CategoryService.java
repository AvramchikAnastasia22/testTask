package com.testTask.service;

import com.testTask.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category getCategoryList(String userName);

    List<Category> findAll();

    Category save(String category);

    Category findById(Integer id);

    Category update(String nameCategory, Category category);

    void deleteCategory(Integer categoryId);

    Category getCategoryByName(String name);
}
