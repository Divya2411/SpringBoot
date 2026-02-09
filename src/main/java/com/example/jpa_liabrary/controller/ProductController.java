package com.example.jpa_liabrary.controller;

import com.example.jpa_liabrary.model.ErrorResponse;
import com.example.jpa_liabrary.entity.Product;
import com.example.jpa_liabrary.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

    @GetMapping("api/products")
    @Operation(summary = "GET end point to fetch all products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product found successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<Product> findAllProducts() {
        return productService.findAllProduct();

    }

    @PostMapping("api/products")
    @Operation(summary = "Post end point to add new products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product Add successfully"),
            @ApiResponse(responseCode = "404", description = "Product not added"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Product> saveProucts(@RequestBody Product product) {


        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-PRODUCT-MARKET", "IN")
                .body(productService.createProducts(product));

    }

    @PutMapping("api/products")
    @Operation(summary = "PUT end point to update product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product update successfully"),
            @ApiResponse(responseCode = "404", description = "Product not updated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Product updateProducts(@RequestBody Product product) {
        return productService.updateProducts(product);
    }

    @DeleteMapping("api/products/{id}")
    @Operation(summary = "DELETE end point to delect product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product DELETE successfully"),
            @ApiResponse(responseCode = "404", description = "Product not DELETED"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void deleteProducts(@PathVariable UUID id) {
        productService.deleteById(id);
    }

    @GetMapping("api/products/{id}")
    @Operation(summary = "GET end point to Fetch product by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product found successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

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

