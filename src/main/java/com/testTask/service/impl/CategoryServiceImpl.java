package com.testTask.service.impl;

import com.testTask.model.Category;
import com.testTask.repository.CategoryRepository;
import com.testTask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category save(String category) {
        Category categoryToSave = new Category();
        categoryToSave.setNameCategory(category);
        return categoryRepository.save(categoryToSave);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category update(String nameCategory, Category category) {

        Category categoryUpdate = categoryRepository.findById(category.getId()).get();
        categoryUpdate.setId(category.getId());
        categoryUpdate.setNameCategory(nameCategory);


        return categoryRepository.save(categoryUpdate);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByNameCategory(name);
    }

    @Override
    public Category getCategoryList(String nameCategory) {
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList.stream()
                .filter(item -> Objects.equals(item.getNameCategory(), nameCategory))
                .findFirst()
                .orElse(null);
    }
}
