package com.example.ems_Backend.dto;


import lombok.Data;

@Data
public class IdentityDto {

    private Integer id;
    private String documentType;
    private String documentNumber;
    private String additionalDetail;

    public IdentityDto(Integer id, String documentType, String documentNumber, String additionalDetail) {
        this.id=id;
        this.documentType=documentType;
        this.documentNumber=documentNumber;
        this.additionalDetail=additionalDetail;
    }
}
