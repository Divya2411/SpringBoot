package com.example.jpa_liabrary;

import com.example.jpa_liabrary.daO.BookRepository;
import com.example.jpa_liabrary.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaLiabraryApplication {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {

        SpringApplication.run(JpaLiabraryApplication.class, args);
    }


    @Bean
    CommandLineRunner init() {
        return args -> {
            List<Book> all = bookRepository.findAll();
            System.out.println("all book" + all);
        };
    }
}