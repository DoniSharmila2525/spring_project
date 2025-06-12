package com.sample.restapi.service;

import com.sample.restapi.entity.CustomerEntity;
import com.sample.restapi.exceptionhandler.CustomerNotFoundException;
import com.sample.restapi.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {
    @Autowired
    private CustomerRepo repository;

    public CustomerEntity create(CustomerEntity customer) {
        return repository.save(customer);
    }

    public CustomerEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));
    }

    public List<CustomerEntity> getAll() {
        return repository.findAll();
    }

    public CustomerEntity update(Long id, CustomerEntity updated) {
        CustomerEntity existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setStatus(updated.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        CustomerEntity customer = getById(id);
        repository.delete(customer);
    }

}
