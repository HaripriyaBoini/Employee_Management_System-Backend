package com.example.ems_Backend.dto;

import com.example.ems_Backend.entity.Employee;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Integer id;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String pinCode;
    private String addressType;

    public AddressDto(String addressLine1, String addressLine2, String addressLine3, String city, String state, String pinCode, String addressType) {
        this.addressLine1=addressLine1;
        this.addressLine2=addressLine2;
        this.city=city;
        this.state=state;
        this.pinCode=pinCode;
        this.addressType=addressType;

    }

}
