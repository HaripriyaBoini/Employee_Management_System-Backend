package com.example.ems_Backend.mapper;

import com.example.ems_Backend.dto.EducationDto;
import com.example.ems_Backend.entity.Education;

public class EducationMapper {


    //map to Education Dto
    public static  EducationDto mapToEducationDto(Education education){
        return new EducationDto(education.getId(), education.getYear(), education.getDegree(), education.getInstitute()
        );

    }



    //Map to Entity education
    public static Education maptoEducation(EducationDto educationDto){
        return new Education(educationDto.getId(),educationDto.getYear(),educationDto.getDegree(),educationDto.getInstitute()
        );






    }
}
