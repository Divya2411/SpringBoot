package com.example.jpa_liabrary.exception;

public class InvalidProductNameException extends RuntimeException{
    public InvalidProductNameException(String s) {
        super(s);
    }
}
