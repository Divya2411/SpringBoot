package com.example.jpa_liabrary.controller;

import com.example.jpa_liabrary.model.ErrorResponse;
import com.example.jpa_liabrary.entity.Product;
import com.example.jpa_liabrary.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("api/product")
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    @PostMapping("api/product")
    public ResponseEntity<Product> saveProucts(@RequestBody Product product) {


        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-PRODUCT-MARKET", "IN")
                .body(productService.createProducts(product));

    }

    @PutMapping("api/product")
    public Product updateProducts(@RequestBody Product product) {
        return productService.updateProducts(product);
    }

    @DeleteMapping("api/product/{id}")
    public void deleteProducts(@PathVariable UUID id) {
        productService.deleteById(id);
    }

    @GetMapping("api/product/{id}")

    public ResponseEntity<?> findById(@PathVariable UUID id) {
        Optional<Product> result = productService.findById(id);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());

        } else {
            ErrorResponse response = ErrorResponse.builder()
                    .errorCode("api-404")
                    .errorMessage("product not found " + id.toString())
                    .errorTimeTamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }
    }
}

