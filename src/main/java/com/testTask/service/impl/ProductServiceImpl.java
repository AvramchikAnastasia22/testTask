package com.testTask.service.impl;

import com.testTask.model.Category;
import com.testTask.model.Product;
import com.testTask.repository.ProductRepository;
import com.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Product createProduct(String name, double cost, String description, String generalDescr, String specialDescr, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setCost(cost);
        product.setDescription(description);
        product.setCategory(category);
        product.setGeneralDescr(generalDescr);
        product.setSpecialDescr(specialDescr);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String name, double cost, String description, String generalDescr, String specialDescr, Category category, Product product) {
        Product productToUpdate = productRepository.findById(product.getId()).get();
        productToUpdate.setId(product.getId());
        productToUpdate.setName(name);
        productToUpdate.setCost(cost);
        productToUpdate.setDescription(description);
        productToUpdate.setCategory(category);
        productToUpdate.setGeneralDescr(generalDescr);
        productToUpdate.setSpecialDescr(specialDescr);
        return productRepository.save(productToUpdate);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product getProductList(String productName) {
        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .filter(item -> Objects.equals(item.getName(), productName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getAllProduct(String keyword) {
        if (keyword != null) {
            return productRepository.findAll(keyword);
        }
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getProductByName(String name1) {
        return productRepository.findByName(name1);
    }
}
