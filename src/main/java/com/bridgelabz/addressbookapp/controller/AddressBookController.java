package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.entity.Address;
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
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getRecordRepoByID(@PathVariable Integer id){
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully",service.getRecordById(id));
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/{firstName}")
    public ResponseEntity<ResponseDTO> getRecordFromRepoByFirstName(@PathVariable String firstName) {
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular firstName retrieved successfully",service.getRecordByFirstName(firstName));
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getRecordFromRepoByName(){
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular name retrieved successfully",service.getRecordByName());
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }
    //localhost:8080/addressbook/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateRecordById(@PathVariable Integer id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record updated successfully", service.updateRecordById(id, addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //localhost:8080/addressbook/delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Address Book Record Deleted successfully", service.deleteRecordById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
