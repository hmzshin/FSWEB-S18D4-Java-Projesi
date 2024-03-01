package com.workintech.s18d4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.s18d4.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
