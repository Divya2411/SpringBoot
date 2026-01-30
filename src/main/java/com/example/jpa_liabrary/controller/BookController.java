package com.example.jpa_liabrary.controller;

import com.example.jpa_liabrary.entity.Author;
import com.example.jpa_liabrary.entity.Book;
import com.example.jpa_liabrary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/book")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/api/book/{id}")
    public Optional<Book> findByIdBooks(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping("/api/book")
    public Book saveBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping("/api/book")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @GetMapping("/api/books")
    public List<Book> findBookByIsbn(@RequestParam("desc") String description,
                                     @RequestParam(name = "isbn", required = false) String isbn) {
        if(null == isbn){

        }

        return bookService.getBooks(description);
    }




    @DeleteMapping("/api/book/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteById(id);
    }


    @PostMapping("/api/books")
    public List<Book> createAllBooks(@RequestBody List<Book> books){
        return bookService.createAllBook(books);
    }



}
