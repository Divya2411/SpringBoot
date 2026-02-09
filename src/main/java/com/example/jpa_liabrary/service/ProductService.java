package com.example.jpa_liabrary.service;

import com.example.jpa_liabrary.daO.ProductRepo;
import com.example.jpa_liabrary.entity.Product;
import com.example.jpa_liabrary.exception.InvalidProductNameException;
import com.example.jpa_liabrary.exception.InvalidProductPriceException;
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
            if(product == null) {
                throw new IllegalArgumentException("Product cannot be null");
            }
            if(product.getName() == null || product.getName().isEmpty()
                    || product.getName().length()<= 5) {
                throw new InvalidProductNameException("Product name is null or less than 5 chars");
            }
            if (product.getPrice() <=0) {
                throw new InvalidProductPriceException("Product price is invalid");
            }
            return productRepo.save(product);        }

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

