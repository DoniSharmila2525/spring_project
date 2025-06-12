package com.sample.restapi.controller;

import com.sample.restapi.service.CustomerServiceImpl;
import com.sample.restapi.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    @Autowired
    private CustomerServiceImpl service;

    @PostMapping
    public ResponseEntity<CustomerEntity> create(@RequestBody CustomerEntity customer) {
        return new ResponseEntity<>(service.create(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public CustomerEntity update(@PathVariable Long id,  @RequestBody CustomerEntity customer) {
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
