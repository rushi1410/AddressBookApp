package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressBookService {
    @Autowired
    AddressRepository repository;

    public Address saveDataToRepo(AddressBookDTO addressBookDTO) {
        Address newAddress = new Address(addressBookDTO);
        repository.save(newAddress);
        return newAddress;
    }


    public List<Address> getRecordByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }
    public Optional<Address> getRecordById(Integer id) {
        Optional<Address> newBook = repository.findById(id);
        return newBook;
    }

    public List<Address> getRecordByName() {
        return repository.findAll();
    }

    public List<Address> getRecord() {
        return repository.findAll();
    }

    public Address updateRecordById(Integer id, AddressBookDTO addressBookDTO) {
        Address newBook = new Address(id, addressBookDTO);
        repository.save(newBook);
        return newBook;
    }

    public String deleteRecordById(Integer id) {
        repository.deleteById(id);
        return null;
    }

}
