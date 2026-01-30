package com.example.jpa_liabrary.service;

import com.example.jpa_liabrary.daO.CustomerRepo;
import com.example.jpa_liabrary.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCus() {
        return customerRepo.findAll();
    }

    public Customer addCus(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer updateCus(Customer customer) {

        return customerRepo.save(customer);
    }

    public void deleteById(UUID id) {
        customerRepo.deleteById(id);
    }

    public Optional<Customer> findById(UUID id) {
        return customerRepo.findById(id);
    }

    public void deleteCus(Customer customer) {
        customerRepo.delete(customer);
    }
}
