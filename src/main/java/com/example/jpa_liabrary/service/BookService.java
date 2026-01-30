package com.example.jpa_liabrary.service;

import com.example.jpa_liabrary.daO.AuthorRepo;
import com.example.jpa_liabrary.daO.BookRepository;
import com.example.jpa_liabrary.entity.Author;
import com.example.jpa_liabrary.entity.Book;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepo authorRepo;


    public BookService(BookRepository bookRepository, AuthorRepo authorRepo) {

        this.bookRepository = bookRepository;
        this.authorRepo = authorRepo;
    }

    public Book createBook(Book book){
        book.setCreateDate(new Date());
        book.setPublishDate(new Date());
        return bookRepository.save(book);
    }

    public Book updateBook(Book book){

        return bookRepository.save(book);
    }

    public List<Book> findAllBooks(){

        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id){

        return bookRepository.findById(id);
    }

    public void deleteById(Long id){

        bookRepository.deleteById(id);
    }

    public Optional<Book> findBookByISBN(String isbn){

        return bookRepository.findByIsbn(isbn);
    }


    public List<Book> createAllBook(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    public List<Book> getBooks(String description){
        return bookRepository.findAllByDescriptionContainingIgnoreCase(description);
    }





}
