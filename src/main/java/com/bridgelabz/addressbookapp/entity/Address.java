package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private long phoneNumber;

    private String email;

    @ElementCollection
    @CollectionTable(name = "address1", joinColumns = @JoinColumn(name = "id"))
    List<String> address;
    public Address() {
    }
    public Address(Integer id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = Collections.singletonList(addressBookDTO.getAddress());
    }
    public Address(AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = Collections.singletonList(addressBookDTO.address);
    }

    public Address(Integer id, String firstName, String lastName, String address,String email,long phoneNumber) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = Collections.singletonList(address);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address.toString();
    }

    public void setAddress(String address) {
        this.address = Collections.singletonList(address);
    }
}
