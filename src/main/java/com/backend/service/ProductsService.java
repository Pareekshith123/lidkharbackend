package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.Dtos.CategoryDto;
import com.backend.Dtos.ProductsDto;
import com.backend.Dtos.UserDto;
import com.backend.Entities.Products;
@Service
public interface  ProductsService {
	ProductsDto createProduct(ProductsDto productsDto, Long categoryId);
	ProductsDto updateProduct(Long categoryId, Long productId,ProductsDto productsDto);

	    List<ProductsDto> getAllProducts();

	    ProductsDto getProductById(Long productId);


	    String deleteProduct(Long productId);
//	    List<ProductsDto> findByNameContainingIgnoreCase(String name);
//		List<ProductsDto> searchProductByName(String name);
	    List<ProductsDto> searchByProductName(String name);
		
}
