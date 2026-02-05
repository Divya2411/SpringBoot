package com.example.jpa_liabrary.exception;

public class InvalidProductPriceException extends RuntimeException{
    public InvalidProductPriceException(String productPriceIsInvalid) {
        super(productPriceIsInvalid);
    }
}
