package com.example.jpa_liabrary.service;

import com.example.jpa_liabrary.daO.ProductRepo;
import com.example.jpa_liabrary.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

        private ProductRepo productRepo;

        public ProductService(ProductRepo productRepo) {
            this.productRepo = productRepo;
        }

        public List<Product> findAllProduct() {
            return productRepo.findAll();
        }

        public Product createProducts(Product product) {
            return productRepo.save(product);
        }

        public Product updateProducts(Product product) {
            return productRepo.save(product);
        }

        public void deleteById(UUID id) {
            productRepo.deleteById(id);
        }

        public Optional<Product> findById(UUID id) {
            return productRepo.findById(id);
        }
    }

