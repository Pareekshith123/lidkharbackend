package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Long> {

}
