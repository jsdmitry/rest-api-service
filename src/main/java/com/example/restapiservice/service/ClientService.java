package com.example.restapiservice.service;
import java.util.List;
import com.example.restapiservice.model.Customer;

public interface ClientService {
    void create(Customer customer);
    List<Customer> readAll();
    Customer read(long id);
    boolean update(Customer customer, long id);
    boolean delete(long id);
}
