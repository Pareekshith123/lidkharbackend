package com.backend.service.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Dtos.CategoryDto;
import com.backend.Entities.Category;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.CategoryRepo;
import com.backend.service.CategorySevice;
@Service
public class CategoryServiceImpl implements CategorySevice{
	@Autowired 
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	Category category =this.dtoToCategory(categoryDto);
	Category category2=this.categoryRepo.save(category);
		return this.categoryToDto(category2);
	}

	@Override
	public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
		
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		category.setTitle(categoryDto.getTitle());
		category.setDescription(categoryDto.getDescription());
		Category updatedCategory=this.categoryRepo.save(category);
		return this.categoryToDto(updatedCategory);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
      List<Category> category = this.categoryRepo.findAll();
      List<CategoryDto> categoryList = category.stream().map(this::categoryToDto).collect(Collectors.toList());


		return categoryList;
	}

	@Override
	public CategoryDto getCategoryById(Long categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public String deleteCategory(Long categoryId) {
		
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		this.categoryRepo.delete(category);
		return "the Category is deleted Successfully";
	}


	  public CategoryDto categoryToDto(Category category) {


	        return this.modelMapper.map(category, CategoryDto.class);
	    }

	    public Category dtoToCategory(CategoryDto categoryDto) {


	        return this.modelMapper.map(categoryDto, Category.class);
	    }
	

}
