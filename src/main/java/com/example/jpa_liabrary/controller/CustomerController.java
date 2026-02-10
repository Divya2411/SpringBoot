package com.example.jpa_liabrary.controller;

import com.example.jpa_liabrary.entity.Customer;
import com.example.jpa_liabrary.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("api/customer")
    public List<Customer> GetAllCustomer(){

        return customerService.getAllCus();
    }

    @PostMapping("api/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCus(customer));
    }
    @PutMapping("api/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCus(customer);
    }

    @DeleteMapping("/api/customer/{id}")
    public void deleteCustomerById(@PathVariable UUID id){
        customerService.deleteById(id);
    }

    @DeleteMapping("/api/customer")
    public void deleteCustomer(@RequestBody Customer customer){
        customerService.deleteCus(customer);
    }

    @GetMapping("/api/customer/{id}")
    public void getCustomerById(@PathVariable UUID id){
        customerService.deleteById(id);
    }


}
