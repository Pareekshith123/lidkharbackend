package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Entities.Category;
import com.backend.Entities.Products;

public interface ProductsRepo extends JpaRepository<Products, Long> {
  List<Products> findByCategotry(Category category); 
}
