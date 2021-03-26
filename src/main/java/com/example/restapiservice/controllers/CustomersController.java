package com.example.restapiservice.controllers;

import com.example.restapiservice.model.Customer;
import com.example.restapiservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> read(@PathVariable(name = "id") long id) {
        final Customer customer = service.read(id);
        return customer != null ?
                new ResponseEntity<>(customer, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<List<Customer>> create(@RequestBody Customer customer) {
        this.service.create(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> update(@PathVariable(name = "id") int id, @RequestBody Customer client) {
        final boolean updated = this.service.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = this.service.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
