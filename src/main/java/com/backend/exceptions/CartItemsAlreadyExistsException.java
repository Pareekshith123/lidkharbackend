package com.backend.exceptions;

public class CartItemsAlreadyExistsException extends RuntimeException{

   
	private static final long serialVersionUID = 1L;
	String message;
    
    public CartItemsAlreadyExistsException() {
	}
    

    public CartItemsAlreadyExistsException(String message) {
        this.message = message;
    }
}
