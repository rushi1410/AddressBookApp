package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
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
    //Created service method which serves controller api to get record by id
    public Address getRecordById(Integer id) {
        Optional<Address> address = repository.findById(id);
        if (address.isPresent()) {
            return address.get();
        } else throw new AddressBookException("Addressbook id not found");
    }

    public List<Address> getRecord() {
        return repository.findAll();
    }

    //Created service method which serves controller api to update record by id
    public Address updateRecordById(Integer id, AddressBookDTO addressBookDTO) {
        Optional<Address> addressBook = repository.findById(id);
        if (addressBook.isEmpty()) {
            throw new AddressBookException("AddressBook details for id not found");
        }
        Address newBook = new Address(id, addressBookDTO);
        repository.save(newBook);
        return newBook;
    }

    //Created service method which serves controller api to delete record by id
    public String deleteRecordById(Integer id) {
        Optional<Address> newAddressBook = repository.findById(id);
        if (newAddressBook.isEmpty()) {
            throw new AddressBookException("Address Book Details not found");
        } else {
            repository.deleteById(id);
        }
        return null;
    }

}
