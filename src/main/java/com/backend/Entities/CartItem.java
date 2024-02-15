package com.backend.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carts")
public class CartItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    private Products products;

    private Integer quantity;


    

	public CartItem() {
		super();
	}




	public CartItem(Long cartItemId, Products products, Integer quantity) {
		super();
		this.cartItemId = cartItemId;
		this.products = products;
		this.quantity = quantity;
	}




	public Long getCartItemId() {
		return cartItemId;
	}




	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}




	public Products getProducts() {
		return products;
	}




	public void setProducts(Products products) {
		this.products = products;
	}




	public Integer getQuantity() {
		return quantity;
	}




	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}

