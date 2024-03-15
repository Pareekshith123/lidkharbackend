package com.backend.service.serviceImpl;

import java.io.IOException;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.cloudinary.utils.ObjectUtils;


import com.cloudinary.Cloudinary;
import com.backend.Dtos.ProductsDto;
import com.backend.Entities.Category;
import com.backend.Entities.Products;
import com.backend.exceptions.ProductNotFoundException;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.CategoryRepo;
import com.backend.repository.ProductsRepo;
import com.backend.service.ProductsService;



@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsRepo productsRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;
  @Autowired
  
  private Cloudinary cloudinary;


  @Override
  public ProductsDto createProduct(ProductsDto productsDto, Long categoryId) {





      Category category = categoryRepo.findById(categoryId)
              .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

      Products products = dtoToProducts(productsDto);
      String productName = productsDto.getProductsName();
      String fileName = productName.replaceAll("\\s", "");

      try {
          Map<?, ?> uploadResult = cloudinary.uploader().upload(productsDto.getEncodedDocument(),
                  ObjectUtils.asMap("public_id", fileName));

          products.setProductsName(productsDto.getProductsName());
          products.setDescription(productsDto.getDescription());
          products.setPrice(productsDto.getPrice());
          products.setImageUrl(uploadResult.get("secure_url").toString());
          products.setSize(products.getSize());
          products.setGender(productsDto.getGender());
          products.setItemCode(productsDto.getItemCode());
          products.setType(productsDto.getType());
          products.setFit(productsDto.getFit());
          products.setToeShape(productsDto.getToeShape());
          products.setUpper(productsDto.getUpper());
          products.setLining(productsDto.getLining());
          products.setSizeRange(productsDto.getSizeRange());
          products.setSole(productsDto.getSole());
          products.setColor(productsDto.getColor());
          products.setSize(productsDto.getSizeRange());
          products.setBoxDim(productsDto.getBoxDim());
          products.setManufacturer(productsDto.getManufacturer());
          products.setThickness(productsDto.getThickness());
          
          
          products.setCategory(category);

          Products newProduct = productsRepo.save(products);
          return productToDto(newProduct);
      } catch (IOException e) {
          e.printStackTrace();
          // Handle the error appropriately, possibly inform the client
          return null;
      }
  }

	@Override
	public ProductsDto updateProduct(Long categoryId, Long productId, ProductsDto productsDto) {




	    Products existingProduct = productsRepo.findById(productId)
	            .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

	    existingProduct.setProductsName(productsDto.getProductsName());
	    String productName = productsDto.getProductsName();
	      String fileName = productName.replaceAll("\\s", "");
	      try {
			Map<?, ?> uploadResult = cloudinary.uploader().upload(productsDto.getEncodedDocument(),
			          ObjectUtils.asMap("public_id", fileName));
			   existingProduct.setDescription(productsDto.getDescription());
			    existingProduct.setImageUrl(uploadResult.get("secure_url").toString());
			    existingProduct.setPrice(productsDto.getPrice());
			    existingProduct.setSize(productsDto.getSize());
			    existingProduct.setGender(productsDto.getGender());
			    existingProduct.setItemCode(productsDto.getItemCode());
			    existingProduct.setType(productsDto.getType());
			    existingProduct.setFit(productsDto.getFit());
			    existingProduct.setToeShape(productsDto.getToeShape());
			    existingProduct.setUpper(productsDto.getUpper());
			    existingProduct.setLining(productsDto.getLining());
			    existingProduct.setSizeRange(productsDto.getSizeRange());

			    existingProduct.setSole(productsDto.getSole());
			    existingProduct.setColor(productsDto.getColor());
			    existingProduct.setSize(productsDto.getSizeRange());
			    existingProduct.setBoxDim(productsDto.getBoxDim());
			    existingProduct.setManufacturer(productsDto.getManufacturer());
			    existingProduct.setThickness(productsDto.getThickness());
		          

			    Category category = categoryRepo.findById(categoryId)
			            .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
			    existingProduct.setCategory(category);

			    Products updatedProduct = productsRepo.save(existingProduct);

			    return productToDto(updatedProduct);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	 
	}



	@Override
	public List<ProductsDto> getAllProducts() {


		List<Products> productList = this.productsRepo.findAll();
		List<ProductsDto> productDtoList = productList.stream().map(this::productToDto).collect(Collectors.toList());
		return productDtoList;
	}

	@Override
	public ProductsDto getProductById(Long productId) {

	    Products products = this.productsRepo.findById(productId)
	            .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

	    return this.productToDto(products);
	}

	@Override
	public String deleteProduct(Long productId) {


		Products products = this.productsRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
		this.productsRepo.delete(products);
		return "the product is deleted Successfully";
	}

	@Override
	public List<ProductsDto> searchByProductName(String name) {
		List<Products> all = this.productsRepo.findByProductsNameContainingIgnoreCase(name);
		List<ProductsDto> collect = all.stream().map((a) ->productToDto(a))
				.collect(Collectors.toList());
		return collect;

	}





	public ProductsDto productToDto(Products products) {



		return this.modelMapper.map(products, ProductsDto.class);

	}

	public Products dtoToProducts(ProductsDto productsDto) {



		return this.modelMapper.map(productsDto, Products.class);

	}



	

}
