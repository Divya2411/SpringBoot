package com.example.jpa_liabrary.service;

import com.example.jpa_liabrary.daO.OrderRepo;
import com.example.jpa_liabrary.entity.Customer;
import com.example.jpa_liabrary.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private OrderRepo orderRepo;


    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    //get
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }
//put
    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

//deleteById
    public void deleteById(UUID id) {
        orderRepo.deleteById(id);
    }

//post
    public Order addOrder(Order order) {

        return orderRepo.save(order);
    }
//delete
    public void deleteOrder(Order order) {
        orderRepo.delete(order);

    }

    public Optional<Order> getById(UUID id) {
       return orderRepo.findById(id);
    }
}
