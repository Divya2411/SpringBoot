package com.example.jpa_liabrary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@Table(name="TABLE_BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author author;
    @Column(unique = true)
    private String isbn;
    private double price;
    @Column(length = 1000)
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    private Date publishDate;
}
