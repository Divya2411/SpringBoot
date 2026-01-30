package com.example.jpa_liabrary.daO;

import com.example.jpa_liabrary.entity.Author;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
