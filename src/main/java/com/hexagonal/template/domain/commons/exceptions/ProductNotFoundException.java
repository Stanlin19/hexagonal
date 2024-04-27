package com.hexagonal.template.domain.commons.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message){
        super(message);
    }
}
