package com.example.ems_Backend.service;

import com.example.ems_Backend.dto.AddressDto;
import com.example.ems_Backend.dto.EducationDto;
import com.example.ems_Backend.entity.Address;
import com.example.ems_Backend.entity.Employee;

import java.util.List;

public interface AddressService {

    //Add Address
    public AddressDto addAddress(AddressDto addressDto, Employee employee);

    //UpdateAddress
    public AddressDto updateAddress(AddressDto addressDto, Integer id);

       //GET ALL addresses
    List<AddressDto> getAllAddresses();

    //Delete address
    public void deleteAddress(Integer id);


    //Get address by id
    public Address getAddress(Integer id);

// Delete employee from address repository
    public void deleteByEmployee(Employee employee);



    //Find Employee from Address
    public List<AddressDto> findByEmployee(Employee employee);


}
