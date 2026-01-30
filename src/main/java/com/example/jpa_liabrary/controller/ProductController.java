package com.example.jpa_liabrary.controller;

import com.example.jpa_liabrary.entity.Product;
import com.example.jpa_liabrary.service.ProductService;
import org.springframework.web.bind.annotation.*;

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
        public List<Product> findAllProduct(){
            return productService.findAllProduct();
        }

        @PostMapping("api/product")
        public Product saveProucts(@RequestBody Product product){
            return productService.createProducts(product);
        }

        @PutMapping("api/product")
        public Product updateProducts(@RequestBody Product product){
            return productService.updateProducts(product);
        }

        @DeleteMapping("api/product/{id}")
        public void deleteProducts(@PathVariable UUID id){
            productService.deleteById(id);
        }

        @GetMapping("api/product/{id}")
        public Optional<Product> findById(@PathVariable UUID id){
            return productService.findById(id);
        }
    }

