package com.example.restapiservice.controllers;

import com.example.restapiservice.model.Customer;
import com.example.restapiservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {
    private final ClientService service;

    @Autowired
    public CustomersController(ClientService service) {
        this.service = service;
    }

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> read() {
        final List<Customer> customers = service.readAll();
        return customers != null && !customers.isEmpty() ?
                new ResponseEntity<>(customers, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
