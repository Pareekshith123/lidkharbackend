package com.backend.service.serviceImpl;

import com.backend.Dtos.CartItemDto;
import com.backend.Dtos.ProductsDto;
import com.backend.Dtos.UserDto;
import com.backend.Entities.CartItem;
import com.backend.Entities.Products;
import com.backend.Entities.User;
import com.backend.exceptions.CartItemsAlreadyExistsException;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.CartItemsRepo;
import com.backend.repository.ProductsRepo;
import com.backend.repository.UserRepo;
import com.backend.service.CartItemsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemsServiceImpl implements CartItemsService {

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private CartItemsRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo; 

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartItemDto AddItemToCart(@NonNull Integer userId, Long productId, CartItemDto cartItemDto) {

	 User userContainer = this.userRepo.findById(userId)
             .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId, "userId", userId));

     Products product = this.productsRepo.findById(productId)
             .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId, "productId", productId));

     CartItem existingCartItem = this.cartItemRepo.findByProductsAndUser(product, userContainer);
     if (existingCartItem != null) {
     	
         throw new CartItemsAlreadyExistsException("Item with product ID " + productId + " already exists in the cart");
     }

     CartItem cartItem = new CartItem();
     cartItem.setProducts(product);
     cartItem.setUser(userContainer);

     if (cartItemDto.getQuantity() == null || cartItemDto.getQuantity() <= 0) {
         cartItem.setQuantity(1); 
     } else {
         cartItem.setQuantity(cartItemDto.getQuantity());
     }

     CartItem savedCartItem = cartItemRepo.save(cartItem);

     ProductsDto productsDto = this.modelMapper.map(product, ProductsDto.class);

     CartItemDto cartItemDto1 = cartItemToDto(savedCartItem);
     cartItemDto1.setProductsDto(productsDto);
     cartItemDto1.setUserDto(this.modelMapper.map(userContainer, UserDto.class));

     return cartItemDto1;}


    @Override
    public String removeFromCart(Integer userId, Long cartItemId) {
        // Retrieve the user
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId, "userId", userId));

        // Retrieve the cart item
        CartItem cartItem = cartItemRepo.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found with ID: " + cartItemId, "cartItemId", cartItemId));

        // Check if the cart item belongs to the specified user
        if (!cartItem.getUser().getUserId().equals(userId)) {
            throw new ResourceNotFoundException("Cart item with ID " + cartItemId + " does not belong to user with ID: " + userId, "userId", userId);
        }

        // Remove the cart item
        cartItemRepo.delete(cartItem);
		return "The cart item is deleted successfully";
    }



    @Override
    public List<CartItemDto> getAllCartItems() {

        List<CartItem> cartItems = cartItemRepo.findAll();
        return cartItems.stream()
                .map(cartItem -> {
                    CartItemDto cartItemDto = modelMapper.map(cartItem, CartItemDto.class);
                    ProductsDto productsDto = modelMapper.map(cartItem.getProducts(), ProductsDto.class);
                    UserDto userDto = modelMapper.map(cartItem.getUser(), UserDto.class); // Map User to UserDto
                    cartItemDto.setProductsDto(productsDto);
                    cartItemDto.setUserDto(userDto);
                    return cartItemDto;
                })
                .collect(Collectors.toList());
    }
    @Override
    public List<CartItemDto> getAllCartItemsByUserId(Integer userId) {


        // Retrieve the user
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId, "userId", userId));
        
        // Retrieve all cart items for the user
        List<CartItem> cartItems = cartItemRepo.findByUser(user);
        
        // Map each cart item to DTO
        return cartItems.stream()
                .map(cartItem -> {
                    CartItemDto cartItemDto = modelMapper.map(cartItem, CartItemDto.class);
                    ProductsDto productsDto = modelMapper.map(cartItem.getProducts(), ProductsDto.class);
                    cartItemDto.setProductsDto(productsDto);
                    return cartItemDto;
                })
                .collect(Collectors.toList());
    }


    @Override
    public CartItemDto incrementQuantity(Long cartItemId) {

        CartItem cartItem = cartItemRepo.findById(cartItemId).orElse(null);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            CartItem updatedItem = cartItemRepo.save(cartItem);
            return modelMapper.map(updatedItem, CartItemDto.class);
        } else {
            return null;
        }
    }

    @Override
    public CartItemDto decrementQuantity(Long cartItemId) {

        CartItem cartItem = cartItemRepo.findById(cartItemId).orElse(null);
        if (cartItem != null && cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            CartItem updatedItem = cartItemRepo.save(cartItem);
            return modelMapper.map(updatedItem, CartItemDto.class);
        } else if (cartItem != null && cartItem.getQuantity() == 1) {
            cartItemRepo.deleteById(cartItemId);
            return null;
        } else {
            return null;
        }
    }

    public CartItemDto cartItemToDto(CartItem cartItem) {

        return modelMapper.map(cartItem, CartItemDto.class);
    }

}
