package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
@Data
public class AddressBookDTO {
    @NotEmpty(message = "First name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "firstName is Invalid")
    private String firstName;

    @NotEmpty(message = "Last name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "lastName is Invalid")
    private String lastName;


    @NotEmpty(message = "Address cant be empty")
    public String address;

    public AddressBookDTO(String firstName, String lastName, String address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
