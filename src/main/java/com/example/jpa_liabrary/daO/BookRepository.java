package com.example.jpa_liabrary.daO;


import com.example.jpa_liabrary.entity.Author;
import com.example.jpa_liabrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);


    List<Book> findAllByDescriptionContainingIgnoreCase(String description);

    @Query("SELECT b FROM Book b WHERE upper(b.description ) Like (:description) ")
    List<Book> findForLikeDesc(Author description);

}

