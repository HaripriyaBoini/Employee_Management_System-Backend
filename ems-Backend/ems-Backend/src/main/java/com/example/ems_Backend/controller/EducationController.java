package com.example.ems_Backend.controller;


import com.example.ems_Backend.dto.EducationDto;
import com.example.ems_Backend.dto.IdentityDto;
import com.example.ems_Backend.entity.Education;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.mapper.EducationMapper;
import com.example.ems_Backend.repository.EducationRepository;

import com.example.ems_Backend.service.EducationService;

import com.example.ems_Backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
//@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;
    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/employee/{empId}/education")
    public ResponseEntity<EducationDto> addEducation(@RequestBody EducationDto educationDto, @PathVariable Integer empId){


        EducationDto  savedEducation= educationService.addEducation(educationDto);

                 return new ResponseEntity<>(savedEducation, HttpStatus.CREATED);}

    @DeleteMapping("education/{eduId}")
    public ResponseEntity<String> deleteEducation(@PathVariable("eduId") Integer id){
        educationService.deleteEducation(id);
        return new ResponseEntity<>("Education Deleted",HttpStatus.OK);
    }

    @PutMapping("education/{eduId}")
    public ResponseEntity<EducationDto> updateEducation(@RequestBody EducationDto educationDto,@PathVariable Integer eduId){
        EducationDto updated_education=educationService.updateEducation(educationDto, eduId);

        return  new ResponseEntity<>(updated_education,HttpStatus.CREATED);
        
    }


    @GetMapping("/education")

    public ResponseEntity<List<EducationDto>> getAllEmployees(){
        List<EducationDto> education = educationService.getAllEducation();
        return ResponseEntity.ok(education);
    }

    }

