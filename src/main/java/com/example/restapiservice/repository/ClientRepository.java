package com.example.restapiservice.repository;

import com.example.restapiservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Customer, Long> {
}
