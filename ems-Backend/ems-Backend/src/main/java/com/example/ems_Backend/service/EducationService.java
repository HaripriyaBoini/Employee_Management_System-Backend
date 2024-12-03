package com.example.ems_Backend.service;

import com.example.ems_Backend.dto.EducationDto;
import com.example.ems_Backend.dto.EmployeeDto;
import com.example.ems_Backend.entity.Education;
import com.example.ems_Backend.entity.Employee;

import java.util.List;

public interface EducationService {

    //add education
    EducationDto addEducation(EducationDto educationDto);

    //update education
    EducationDto updateEducation(EducationDto educationDto, Integer id);

    //Delete education
    void deleteEducation(Integer id);

    //find by employee
    List<Education> findByEmployee(EmployeeDto employeeDto);


    List<EducationDto> getAllEducation();
}
