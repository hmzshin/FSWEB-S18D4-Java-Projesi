package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private AddressService addressService;


    @GetMapping(path = "/{id}")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PutMapping(path = "/{id}")
    public Address update(@RequestBody Address address, Long id) {
        return addressService.update(address, id);
    }

    @DeleteMapping(path = "/{id}")
    public Address delete(@PathVariable Long id) {
        return addressService.delete(id);
    }
}
