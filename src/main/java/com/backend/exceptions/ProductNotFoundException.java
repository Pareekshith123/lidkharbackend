package com.backend.exceptions;

public class ProductNotFoundException extends RuntimeException {
	  String resourceName;
	  String fieldName;
	  String fieldValue;
	public ProductNotFoundException( String resourceName, String fieldName, String fieldValue) {

	    super(String.format("%s is not found with %s : %s ",resourceName,fieldName,fieldValue));
	    this.resourceName = resourceName;
	    this.fieldName = fieldName;
	    this.fieldValue = fieldValue;
	}

}
