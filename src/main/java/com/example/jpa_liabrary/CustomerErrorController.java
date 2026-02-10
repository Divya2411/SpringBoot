package com.example.jpa_liabrary;

import com.example.jpa_liabrary.exception.InvalidCustomerEmailException;
import com.example.jpa_liabrary.exception.InvalidCustomerFirstNameException;
import com.example.jpa_liabrary.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CustomerErrorController {

    @ExceptionHandler(InvalidCustomerFirstNameException.class)
    public ResponseEntity<ErrorResponse> handleCustomerFirstNameException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder().errorCode("API-410")
                        .errorMessage(ex.getMessage())
                        .errorTimeTamp(Instant.now())
                        .build());
    }

    @ExceptionHandler(InvalidCustomerEmailException.class)
    public ResponseEntity<ErrorResponse> handleCustomerEmailException(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .errorCode("API-420")
                        .errorMessage(ex.getMessage())
                        .errorTimeTamp(Instant.now())
                        .build());
    }
}
