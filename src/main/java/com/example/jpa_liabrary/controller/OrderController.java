package com.example.jpa_liabrary.controller;

import com.example.jpa_liabrary.entity.Customer;
import com.example.jpa_liabrary.entity.Order;
import com.example.jpa_liabrary.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("api/order")
    public List<Order> GetAllOrder(){

        return orderService.getAllOrder();
    }

    @PostMapping("api/order")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @PutMapping("api/order")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/api/order/{id}")
    public void deleteOrderById(@PathVariable UUID id){
        orderService.deleteById(id);
    }

    @DeleteMapping("/api/order")
    public void deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
    }

    @GetMapping("/api/order/{id}")
    public void getOrderById(@PathVariable UUID id){
        orderService.getById(id);
    }


}
