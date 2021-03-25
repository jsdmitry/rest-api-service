package com.example.restapiservice.service;
import com.example.restapiservice.model.Customer;
import com.example.restapiservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
       this.clientRepository = clientRepository;
    }

    @Override
    public void create(Customer customer) {
        this.clientRepository.save(customer);
    }

    @Override
    public List<Customer> readAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Customer read(long id) {
        return this.clientRepository.getOne(id);
    }

    @Override
    public boolean update(Customer customer, long id) {
        if (this.clientRepository.existsById(id)) {
            customer.setId(id);
            this.clientRepository.save(customer);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(long id) {
        if (this.clientRepository.existsById(id)) {
            this.clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
