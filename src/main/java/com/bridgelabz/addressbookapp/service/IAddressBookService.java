package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.Address;

import java.util.List;

public interface IAddressBookService {

     public Address saveDataToRepo(AddressBookDTO addressBookDTO);

     public Address getRecordById(Integer id);

     public List<Address> getRecord();

     public Address updateRecordById(Integer id, AddressBookDTO addressBookDTO);

     public String deleteRecordById(Integer id);
}
