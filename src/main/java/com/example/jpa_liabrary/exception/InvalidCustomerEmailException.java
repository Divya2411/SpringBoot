package com.example.jpa_liabrary.exception;

public class InvalidCustomerEmailException extends RuntimeException{

    public InvalidCustomerEmailException(String s) {
        super(s);
    }
}
