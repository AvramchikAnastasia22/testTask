package com.testTask.repository;

import com.testTask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
  //  @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
 //   +" OR p.description  LIKE %?1%"
  //  + " OR p.generalDescr  LIKE %?1%")
    @Query("SELECT p FROM Product p WHERE "
            +"CONCAT(p.id, p.name, p.description, p.generalDescr, p.cost, p.category.nameCategory)"
            +" LIKE %?1%")
List<Product> findAll(String keyword);
    Product findByName(String name1);
}
