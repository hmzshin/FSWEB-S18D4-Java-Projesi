package com.workintech.s18d4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @SuppressWarnings("null")
    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElseThrow(() -> new RuntimeException("Customer with given id could not find"));
    }

    @SuppressWarnings("null")
    @Override
    public Customer delete(Long id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer, Long id) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

}
