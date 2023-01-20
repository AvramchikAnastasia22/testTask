package com.testTask.controller;

import com.testTask.model.User;
import com.testTask.repository.UserRepository;
import com.testTask.service.CategoryService;
import com.testTask.service.ProductService;
import com.testTask.service.UserService;
import com.testTask.utils.TypeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    private void createDefaultUsers() {
        User user = new User();
        user.setName("Анастасия");
        user.setEmail("simpleUser@gmail.com");
        user.setPassword("admin");
        user.setRole(String.valueOf(TypeRole.SIMPLE_USER));
        User user2 = new User();
        user2.setName("Анастасия");
        user2.setEmail("advancedUser@gmail.com");
        user2.setPassword("admin");
        user2.setRole(String.valueOf(TypeRole.ADVANCED_USER));
        userRepository.save(user2);
        User user3 = new User();
        user3.setName("Анастасия");
        user3.setEmail("admin@gmail.com");
        user3.setPassword("admin");
        user3.setRole(String.valueOf(TypeRole.ADMIN));
        userRepository.save(user3);
        userRepository.save(user);
    }

    @PostMapping("/autorization_user")
    private String autorization_user(@RequestParam String login, @RequestParam String password) {
        List<User> users = userService.getUsersList();
        Boolean check = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(login) && users.get(i).getPassword().equals(password)) {


                if (users.get(i).getRole().equals("SIMPLE_USER")) {
                    return "/simpleHome";
                } else if (users.get(i).getRole().equals("ADVANCED_USER")) {
                    return "/advancedHome";
                } else {
                    return "/adminHome";
                }

            }
        }

        return ("redirect:/auth");
    }

    @GetMapping("/adminHome")
    private String adminHome(Model model) {
        return "adminHome";
    }

    @GetMapping("/home")
    private String shop(Model model) {
        createDefaultUsers();
        return "auth";
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/index2")
    public String getIndex2(Model model, @Param("keyword") String keyword) {
        model.addAttribute("prod", productService.getAllProduct(keyword));
        model.addAttribute("keyword", keyword);
        return "index2";
    }


}
