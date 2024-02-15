package com.backend.service.serviceImpl;

import com.backend.Dtos.CartItemDto;
import com.backend.Dtos.ProductsDto;
import com.backend.Entities.CartItem;
import com.backend.Entities.Products;
import com.backend.exceptions.CartItemsAlreadyExistsException;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.CartItemsRepo;
import com.backend.repository.ProductsRepo;
import com.backend.service.CartItemsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemsServiceImpl implements CartItemsService {

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private CartItemsRepo cartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartItemDto AddItemToCart(Long productId, CartItemDto cartItemDto) {
        Products products = this.productsRepo.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product not found with ID: " + productId, "productId", productId));

        CartItem existingCartItem = this.cartItemRepository.findByProducts(products);

        if (existingCartItem != null) {
            throw new CartItemsAlreadyExistsException("Item with product ID " + productId + " already exists in the cart");
        }

        CartItem cartItem = new CartItem();
        cartItem.setProducts(products);

        if (cartItemDto.getQuantity() == null) {
            cartItem.setQuantity(1);
        } else {
            cartItem.setQuantity(cartItemDto.getQuantity());
        }

        CartItem item = cartItemRepository.save(cartItem);

        ProductsDto productsDto = this.modelMapper.map(products, ProductsDto.class);
        CartItemDto cartItemDto1 = cartItemToDto(item);
        cartItemDto1.setProductsDto(productsDto);

        return cartItemDto1;
    }

    @Override
    public void removeFromCart(Long cartId) {
        cartItemRepository.deleteById(cartId);
    }

    @Override
    public List<CartItemDto> getAllCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
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
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElse(null);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            CartItem updatedItem = cartItemRepository.save(cartItem);
            return modelMapper.map(updatedItem, CartItemDto.class);
        } else {
            return null;
        }
    }

    @Override
    public CartItemDto decrementQuantity(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElse(null);
        if (cartItem != null && cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            CartItem updatedItem = cartItemRepository.save(cartItem);
            return modelMapper.map(updatedItem, CartItemDto.class);
        } else if (cartItem != null && cartItem.getQuantity() == 1) {
            cartItemRepository.deleteById(cartItemId);
            return null;
        } else {
            return null;
        }
    }

    public CartItemDto cartItemToDto(CartItem cartItem) {
        return modelMapper.map(cartItem, CartItemDto.class);
    }

	
}
