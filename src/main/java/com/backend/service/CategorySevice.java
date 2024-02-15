package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.Dtos.CategoryDto;
@Service
public interface CategorySevice {
	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);

	    List<CategoryDto> getAllCategories();

	    CategoryDto getCategoryById(Long categoryId);

	    String deleteCategory(Long categoryId);
}
