package com.workintech.s18d4.service;

import java.util.List;

import com.workintech.s18d4.entity.Customer;

public interface CustomerService {

    List<Customer> findAll();

    Customer save(Customer customer);

    Customer findById(Long id);

    Customer delete(Long id);

}
