package com.testTask.controller;

import com.testTask.model.Category;
import com.testTask.model.Product;
import com.testTask.service.CategoryService;
import com.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/category")
    public String getCategory(Model model) {
        model.addAttribute("categors", categoryService.findAll());
        return "category";
    }


    @GetMapping("/category/add")
    public String addCategory(Model model) {
        return "category-add";
    }

    @PostMapping("/category/add")
    public String addCategory(@RequestParam String nameCategory, Model model) {
        categoryService.save(nameCategory);
        return "redirect:/category";
    }

    @PostMapping("/update-category/{name}")
    public String updateCategory(@PathVariable(name = "name") String name,
                                 @Validated Category category, @RequestParam String nameCategory,
                                 BindingResult result,
                                 Model model) {
        category = categoryService.getCategoryByName(name);
        categoryService.update(nameCategory, category);

        return "redirect:/category";
    }

    @GetMapping("/edit-category/{name}")
    public String editCategoryPoint(@PathVariable(name = "name") String name,
                                    Model model) {
        model.addAttribute("category", categoryService.getCategoryList(name));
        return "update-category";
    }


    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable(name = "id") Integer id, Model model) {
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }


}
