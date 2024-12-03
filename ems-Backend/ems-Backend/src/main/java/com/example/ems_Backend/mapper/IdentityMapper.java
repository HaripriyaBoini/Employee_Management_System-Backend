package com.example.ems_Backend.mapper;

import com.example.ems_Backend.dto.IdentityDto;
import com.example.ems_Backend.entity.Identity;

public class IdentityMapper {
    public static IdentityDto mapToIdentityDto(Identity identity) {
        return new IdentityDto(identity.getId(), identity.getDocumentType(), identity.getDocumentNumber(), identity.getAdditionalDetail()
        );
    }


    public static Identity mapToIdentity(IdentityDto identityDto) {
        return new Identity(identityDto.getId(), identityDto.getDocumentType(), identityDto.getDocumentNumber(), identityDto.getAdditionalDetail()
        );
    }

}





