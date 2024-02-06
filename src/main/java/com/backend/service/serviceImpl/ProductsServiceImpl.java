package com.backend.service.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.Dtos.ProductsDto;
import com.backend.Entities.Category;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.CategoryRepo;
import com.backend.repository.ProductsRepo;
import com.backend.service.ProductsService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import ch.qos.logback.core.model.Model;

public class ProductsServiceImpl implements ProductsService{
	@Autowired
	private ProductsRepo productsRepo;
	@Autowired 
	private ModelMapper modelMapper;
	@Autowired
	private CategoryRepo categoryRepo;
	

	@Override
	public ProductsDto createProduct(ProductsDto productsDto, Long categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Product", "categoryId", categoryId));
		
		return null;
	}

	@Override
	public ProductsDto updateProduct(long categoryId, long productId, ProductsDto productsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductsDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsDto getUserById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}


}
