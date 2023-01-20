package com.testTask.controller;

import com.testTask.service.CategoryService;
import com.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class SimpleUserController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/simpleHome")
    private String simpleHome(Model model) {

        return "simpleHome";
    }

    @GetMapping("/simplcategory")
    private String simpCategory(Model model) {
        model.addAttribute("categor", categoryService.findAll());
        return "categorySimple";
    }

}
