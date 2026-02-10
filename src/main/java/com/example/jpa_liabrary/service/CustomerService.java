package com.example.jpa_liabrary.service;

import com.example.jpa_liabrary.daO.CustomerRepo;
import com.example.jpa_liabrary.entity.Customer;
import com.example.jpa_liabrary.exception.InvalidCustomerEmailException;
import com.example.jpa_liabrary.exception.InvalidCustomerFirstNameException;
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
        if(customer == null){
            throw new IllegalArgumentException("customer can't be null");
        }if(customer.getFirstName() == null || customer.getFirstName().isEmpty()){
            throw new InvalidCustomerFirstNameException("you must enter first Name");
        }

        if( customer.getEmail() == null || customer.getEmail().isEmpty() || customer.getEmail().length() < 5){
            throw new InvalidCustomerEmailException("please enter correct email ");
        }
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
