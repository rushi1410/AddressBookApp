package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {

     Address saveDataToRepo(AddressBookDTO addressBookDTO);


     List<Address> getRecord();
     List<Address> getRecordByFirstName(String firstName);
     List<Address> getRecordByName();
     public Optional<Address> getRecordById(Integer id);

     Address updateRecordById(Integer id, AddressBookDTO addressBookDTO);

     String deleteRecordById(Integer id);

}
