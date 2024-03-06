package com.workintech.s18d4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }


    @Override
    public Address update(Address address, Long id) {
        address.setId(id);
        return addressRepository.save(address);
    }

    @SuppressWarnings("null")
    @Override
    public Address findById(Long id) {
        Optional<Address> existingAddress = addressRepository.findById(id);
        return existingAddress.orElseThrow(() -> new RuntimeException("Address with given id could not find"));
    }

    @SuppressWarnings("null")
    @Override
    public Address delete(Long id) {
        Address address = findById(id);
        addressRepository.delete(address);
        return address;
    }

}
