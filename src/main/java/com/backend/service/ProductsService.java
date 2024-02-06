package com.backend.service;

import java.util.List;

import com.backend.Dtos.CategoryDto;
import com.backend.Dtos.ProductsDto;
import com.backend.Dtos.UserDto;
import com.backend.Entities.Products;

public interface  ProductsService {
	ProductsDto createProduct(ProductsDto productsDto, Long categoryId);
	ProductsDto updateProduct(long categoryId, long productId,ProductsDto productsDto);

	    List<ProductsDto> getAllUsers();

	    ProductsDto getUserById(Long productId);

	    String deleteUser(Integer productId);

}
