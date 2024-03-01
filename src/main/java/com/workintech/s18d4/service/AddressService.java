package com.workintech.s18d4.service;

import java.util.List;

import com.workintech.s18d4.entity.Address;

public interface AddressService {

    List<Address> findAll();

    Address save(Address address);

    Address findById(Long id);

    Address delete(Long id);

}
