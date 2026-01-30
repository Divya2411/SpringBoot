package com.example.jpa_liabrary.daO;

import com.example.jpa_liabrary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, UUID> {
}
