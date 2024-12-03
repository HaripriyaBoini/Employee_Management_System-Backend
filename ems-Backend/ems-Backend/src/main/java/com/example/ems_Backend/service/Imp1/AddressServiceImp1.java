package com.example.ems_Backend.service.Imp1;


import com.example.ems_Backend.dto.AddressDto;
import com.example.ems_Backend.dto.EducationDto;
import com.example.ems_Backend.entity.Address;
import com.example.ems_Backend.entity.Education;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.exception.ResourceNotFoundException;
import com.example.ems_Backend.mapper.AddressMapper;
import com.example.ems_Backend.mapper.EducationMapper;
import com.example.ems_Backend.repository.AddressRepository;
import com.example.ems_Backend.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImp1 implements AddressService {

    private AddressRepository addressRepository;
    @Override
    public AddressDto addAddress(AddressDto addressDto, Employee employee) {

       Address address= AddressMapper.mapToAddress(addressDto);
        address.setEmployee(employee);
        Address savedAddress=addressRepository.save(address);
        return AddressMapper.mapToAddressDto(savedAddress);


    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, Integer id) {
        Address address=addressRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("address not exhist with id"+id));
        Address address2= AddressMapper.mapToAddress(addressDto);
Address updated_address=addressRepository.save(address2);
return AddressMapper.mapToAddressDto(updated_address);



    }

    @Override
    public List<AddressDto> getAllAddresses() {
       List<Address> allAddresses= addressRepository.findAll();
        return allAddresses.stream().map((address)-> AddressMapper.mapToAddressDto(address))
                .collect(Collectors.toList());



        }


    @Override
    @Transactional
    public void deleteAddress(Integer id) {
         addressRepository.deleteById(id);
    }



    @Override
    public Address getAddress(Integer id) {
       return addressRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("address not exhist with id"+id)
               );
    }



    @Override
    public void deleteByEmployee(Employee employee) {
        addressRepository.deleteByEmployee(employee);
    }

//
//
    @Override
    public List<AddressDto> findByEmployee(Employee employee) {
        return addressRepository.findByEmployee(employee);
//    }
    }
}
