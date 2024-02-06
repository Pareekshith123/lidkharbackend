package com.backend.service;

import java.util.List;

import com.backend.Dtos.CategoryDto;

public interface CategorySevice {
	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);

	    List<CategoryDto> getAllCategories();

	    CategoryDto getCategoryById(Long categoryId);

	    String deleteCategory(Long categoryId);
}
