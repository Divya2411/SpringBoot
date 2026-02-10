package com.example.jpa_liabrary.exception;

public class InvalidCustomerFirstNameException extends RuntimeException {
    public InvalidCustomerFirstNameException(String s) {
        super(s);
    }
}
