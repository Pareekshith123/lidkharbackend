package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.Entities.CartItem;
import com.backend.Entities.Products;
import com.backend.Entities.User;
@Repository
public interface CartItemsRepo extends JpaRepository<CartItem, Long> {
    CartItem findByProducts(Products products);
    List<CartItem> findByUser(User user);
	CartItem findByProductsAndUser(Products product, User user);
}

