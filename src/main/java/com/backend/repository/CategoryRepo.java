package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.Entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
	 @Query("SELECT c FROM Category c LEFT JOIN FETCH c.products WHERE c.categoryId = ?1")
	    Category findCategoryWithProducts(Long categoryId);

}
