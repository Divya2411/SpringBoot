package com.example.jpa_liabrary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
