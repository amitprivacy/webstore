package com.amit.webstore.exception;

public class InvalidCartException extends RuntimeException {

	private static final long serialVersionUID = -1710363230639335378L;
	
	private String cartId; 
	 
    public InvalidCartException(String cartId) { 
       this.cartId = cartId; 
    } 

    public String getCartId() { 
       return cartId; 
    } 
}
