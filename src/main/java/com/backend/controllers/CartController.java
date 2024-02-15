package com.backend.controllers;

import com.backend.Dtos.CartItemDto;

import com.backend.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartItemsService cartItemsService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<CartItemDto> addItemToCart(@PathVariable Long productId, @RequestBody CartItemDto cartItemDto) {
        CartItemDto addedItem = cartItemsService.AddItemToCart(productId, cartItemDto);
        return ResponseEntity.ok(addedItem);
    }

    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartId) {

        cartItemsService.removeFromCart(cartId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<CartItemDto>> getAllCartItems() {

        List<CartItemDto> cartItems = cartItemsService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @PutMapping("/increment/{cartItemId}")
    public ResponseEntity<CartItemDto> incrementCartItemQuantity(@PathVariable Long cartItemId) {
        CartItemDto updatedItem = cartItemsService.incrementQuantity(cartItemId);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/decrement/{cartItemId}")
    public ResponseEntity<CartItemDto> decrementCartItemQuantity(@PathVariable Long cartItemId) {
        CartItemDto updatedItem = cartItemsService.decrementQuantity(cartItemId);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
