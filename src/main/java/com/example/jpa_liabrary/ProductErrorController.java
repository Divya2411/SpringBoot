package com.example.jpa_liabrary;



import com.example.jpa_liabrary.exception.InvalidProductNameException;
import com.example.jpa_liabrary.exception.InvalidProductPriceException;
import com.example.jpa_liabrary.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@ControllerAdvice
public class ProductErrorController {

    @ExceptionHandler(InvalidProductNameException.class)
    public ResponseEntity<ErrorResponse> handleProductNameException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder().errorCode("API-410")
                        .errorMessage(ex.getMessage())
                        .errorTimeTamp(Instant.now())
                        .build());
    }

    @ExceptionHandler(InvalidProductPriceException.class)
    public ResponseEntity<ErrorResponse> handlePrice(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder().errorCode("API-411")
                        .errorMessage(ex.getMessage())
                        .errorTimeTamp(Instant.now())
                        .build());
    }
}
