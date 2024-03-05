package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.Dtos.CartItemDto;
@Service
public interface CartItemsService {
    CartItemDto AddItemToCart(Integer userId, Long productId,CartItemDto cartItemDto);


    List<CartItemDto> getAllCartItems();

    public CartItemDto incrementQuantity(Long cartItemId);

    public CartItemDto decrementQuantity(Long cartItemId);
    List<CartItemDto> getAllCartItemsByUserId(Integer userId);

	String  removeFromCart(Integer userId, Long cartItemId);

    }
