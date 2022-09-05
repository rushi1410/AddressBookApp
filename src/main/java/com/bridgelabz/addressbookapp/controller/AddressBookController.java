package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    AddressService service;

    //Ability to store address book record to repo
    //localhost:8080/addressbook/create
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> saveDataToRepo(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record created successfully", service.saveDataToRepo(addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    //localhost:8080/addressbook/get
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getDataFromRepo() {
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record retrieved successfully",service.getRecord());
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    //Ability to get address  record by id
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getRecordFromRepoByID(@PathVariable Integer id) throws AddressBookException {
        Optional<Address> newAddress = Optional.ofNullable(service.getRecordById(id));
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    //localhost:8080/addressbook/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateRecordById(@PathVariable Integer id, @Valid @RequestBody AddressBookDTO addressBookDTO) throws AddressBookException  {
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record updated successfully", service.updateRecordById(id, addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //localhost:8080/addressbook/delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable Integer id)  throws AddressBookException{
        ResponseDTO dto = new ResponseDTO("Address Book Record Deleted successfully", service.deleteRecordById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
