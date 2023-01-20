package com.testTask.service;

import com.testTask.model.Category;
import com.testTask.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product createProduct(String name, double cost, String description, String generalDescr, String specialDescr, Category category);

    Product updateProduct(String name, double cost, String description, String generalDescr, String specialDescr, Category category, Product product);

    void deleteProduct(Integer productId);

    Product getProductList(String productName);

    List<Product> getAllProduct(String keyword);


    Product getProductByName(String name1);
}
