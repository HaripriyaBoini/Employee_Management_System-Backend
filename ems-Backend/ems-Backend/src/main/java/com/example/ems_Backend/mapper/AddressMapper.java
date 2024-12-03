package com.example.ems_Backend.mapper;

import com.example.ems_Backend.dto.AddressDto;
import com.example.ems_Backend.entity.Address;

public class AddressMapper {

    //map to AddressDto
    public static AddressDto mapToAddressDto(Address address) {


        return new AddressDto(address.getAddressLine1(), address.getAddressLine2(), address.getAddressLine3(), address.getCity(), address.getState(), address.getPinCode(), address.getAddressType()
        );
    }

    //map to Address
    public static Address mapToAddress(AddressDto addressDto) {


        return new Address(addressDto.getAddressLine1(), addressDto.getAddressLine2(), addressDto.getAddressLine3(), addressDto.getCity(), addressDto.getState(), addressDto.getPinCode(), addressDto.getAddressType()
        );
    }

}
