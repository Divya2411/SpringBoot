package com.example.jpa_liabrary.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   // @Schema(example = "007")
    private UUID id;
    private String name;
    private Double price;

    //TODO [Reverse Engineering] generate columns from DB
}