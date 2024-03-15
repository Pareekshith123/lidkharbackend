package com.backend.controllers;

import com.backend.Dtos.CartItemDto;

import com.backend.service.CartItemsService;

import org.apache.logging.log4j.message.Message;
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

    @PostMapping("/add/{userId}/{productId}")
    public ResponseEntity<CartItemDto> addItemToCart(@PathVariable Integer userId,@PathVariable Long productId, @RequestBody CartItemDto cartItemDto) {


try {

    CartItemDto addedItem = cartItemsService.AddItemToCart(userId,productId, cartItemDto);
    return ResponseEntity.ok(addedItem);
} catch (Exception e) {
	e.printStackTrace();
return null;
}
    }
    @GetMapping("/user/items/{userId}")
   public ResponseEntity<List<CartItemDto>> getAllCartItemsByUserId(@PathVariable Integer userId) {


        List<CartItemDto> cartItems = cartItemsService.getAllCartItemsByUserId(userId);
        return ResponseEntity.ok(cartItems);
    }
    @DeleteMapping("/remove/{userId}/{cartItemId}")
    public String  removeCartItemByUserId( @PathVariable Integer userId,@PathVariable Long cartItemId) {


       this.cartItemsService.removeFromCart(userId, cartItemId);
       return "The cart item is deleted successfully";
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
