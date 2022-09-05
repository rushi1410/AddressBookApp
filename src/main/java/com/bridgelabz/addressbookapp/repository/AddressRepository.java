package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
