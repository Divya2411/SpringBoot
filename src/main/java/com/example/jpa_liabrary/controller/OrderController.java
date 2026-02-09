package com.example.jpa_liabrary.controller;

import com.example.jpa_liabrary.entity.Customer;
import com.example.jpa_liabrary.entity.Order;
import com.example.jpa_liabrary.entity.Product;
import com.example.jpa_liabrary.model.ErrorResponse;
import com.example.jpa_liabrary.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("api/order")
    @Operation(summary = "GET end point to fetch all products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product found successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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
    public ResponseEntity<?> getOrderById(@PathVariable UUID id){
        Optional<Order> result =  orderService.getById(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }else{

                      ErrorResponse response = ErrorResponse.builder()
                              .errorCode("api-404")
                    .errorMessage("product not found " + id.toString())
                    .errorTimeTamp(Instant.now())
                    .build();
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


}
