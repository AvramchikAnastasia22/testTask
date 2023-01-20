package com.testTask.controller;

import com.testTask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdvanUserController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/advancedHome")
    private String advancedHome(Model model) {
        return "advancedHome";
    }

    @GetMapping("/categorySimple")
    private String carS(Model model) {
        model.addAttribute("categor", categoryService.findAll());
        return "categorySimple";
    }
}
