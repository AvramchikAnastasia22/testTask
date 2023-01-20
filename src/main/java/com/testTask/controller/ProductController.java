package com.testTask.controller;

import com.testTask.model.Category;
import com.testTask.model.Product;

import com.testTask.service.CategoryService;
import com.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String getProductList() {
        return null;
    }

    @GetMapping("/index")
    public String getIndex(Model model, @Param("keywor") String keywor) {
        model.addAttribute("products", productService.getAllProduct(keywor));
        model.addAttribute("keywor", keywor);
        return "index";
    }


    @GetMapping("/product/add")
    public String addProduct(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product-add";
    }

    @PostMapping("/product/add")
    public String addProd(@RequestParam String name, @RequestParam double cost, @RequestParam String description,
                          @RequestParam String generalDescr, @RequestParam String specialDescr, @RequestParam Category category, Model model) {
        productService.createProduct(name, cost, description, generalDescr, specialDescr, category);
        return "redirect:/index";
    }

    @PostMapping("/update-product/{name}")
    public String updateProd(@PathVariable(name = "name") String name1, @Validated Product product,
                             @RequestParam String name, @RequestParam double cost, @RequestParam String description,
                             @RequestParam String generalDescr, @RequestParam String specialDescr, @RequestParam Category category, Model model) {
        product = productService.getProductByName(name1);
        productService.updateProduct(name, cost, description, generalDescr, specialDescr, category, product);

        return "redirect:/index";
    }

    @GetMapping("/edit/{name}")
    public String editProdPoint(@PathVariable(name = "name") String name,
                                Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", productService.getProductList(name));
        return "update-product";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id, Model model) {
        productService.deleteProduct(id);
        return "redirect:/index";
    }


}
