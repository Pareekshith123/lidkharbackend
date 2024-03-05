package com.backend.Dtos;

import java.util.ArrayList;
import java.util.List;

import com.backend.Entities.User;

public class CartItemDto {

	private Long cartItemId;

	private Integer quantity;

	private UserDto userDto;
	
private ProductsDto productsDto;


	public CartItemDto() {
		super();
	}


	public CartItemDto(Long cartItemId, Integer quantity, UserDto userDto, ProductsDto productsDto) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.userDto = userDto;
		this.productsDto = productsDto;
	}


	public Long getCartItemId() {
		return cartItemId;
	}


	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public UserDto getUserDto() {
		return userDto;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}


	public ProductsDto getProductsDto() {
		return productsDto;
	}


	public void setProductsDto(ProductsDto productsDto) {
		this.productsDto = productsDto;
	}





}
