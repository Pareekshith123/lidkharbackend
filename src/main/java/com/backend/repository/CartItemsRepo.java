package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.Entities.CartItem;
import com.backend.Entities.Products;
@Repository
public interface CartItemsRepo extends JpaRepository<CartItem, Long> {
    CartItem findByProducts(Products products);
}

