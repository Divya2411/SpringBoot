package com.example.jpa_liabrary.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TABLE_ORDER")
@NoArgsConstructor
     
public class Order {
     @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
    private Instant orderDate = Instant.now();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
