package com.workintech.s18d4.controller;

import org.springframework.web.bind.annotation.*;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping
    public List<Customer> finAll() {
        return customerService.findAll();
    }

    @GetMapping
    public Customer finAllById(@PathVariable Long id) {
        return customerService.findById(id);
    }


    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer) {

        Customer savedCustomer = customerService.save(customer);

        return new CustomerResponse(savedCustomer.getId(), savedCustomer.getEmail(), savedCustomer.getSalary());

    }

    @PutMapping(path = "/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable Long id) {
        return customerService.update(customer, id);
    }

    @DeleteMapping(path = "/{id}")
    public Customer delete(@PathVariable Long id) {
        return customerService.delete(id);
    }
}
