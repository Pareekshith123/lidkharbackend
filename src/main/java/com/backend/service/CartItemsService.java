package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.Dtos.CartItemDto;
@Service
public interface CartItemsService {
    CartItemDto AddItemToCart(Long productId,CartItemDto cartItemDto);

    void removeFromCart(Long cartId);

    List<CartItemDto> getAllCartItems();

    public CartItemDto incrementQuantity(Long cartItemId);

    public CartItemDto decrementQuantity(Long cartItemId);


    }
