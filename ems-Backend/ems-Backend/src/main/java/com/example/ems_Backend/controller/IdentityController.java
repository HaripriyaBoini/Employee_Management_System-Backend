package com.example.ems_Backend.controller;


import com.example.ems_Backend.dto.EmployeeDto;
import com.example.ems_Backend.dto.IdentityDto;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.entity.Identity;
import com.example.ems_Backend.exception.ResourceNotFoundException;
import com.example.ems_Backend.service.EmployeeService;
//import com.example.ems_Backend.service.IdentityService;
import com.example.ems_Backend.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class IdentityController {
    @Autowired
    public IdentityService identityService;
    @Autowired
    private EmployeeService employeeservice;

    @PostMapping("/identity/employee/{empId}")
public ResponseEntity<IdentityDto> addIdentity(@RequestBody IdentityDto identityDto,@PathVariable Integer id){
        Employee employee=new Employee();
        IdentityDto save_identity=identityService.addIdentity(identityDto, employee);
                return new ResponseEntity<>(save_identity, HttpStatus.CREATED);
    }

    @PutMapping("identity/{id}")
    public ResponseEntity<IdentityDto> updateIdentity(@PathVariable Integer id,@RequestBody IdentityDto identityDto){
        IdentityDto updated_identity=identityService.updateIdentity(identityDto,id);
        return new ResponseEntity<>(updated_identity,HttpStatus.CREATED);

    }



    @DeleteMapping("identity/{id}")
    public ResponseEntity<String> deleteIdentity(Integer id){
        identityService.deleteIdentity(id);
        return new ResponseEntity<>("identity with id deleted successfully",HttpStatus.OK);
    }

//get all identities
    @GetMapping
    public ResponseEntity<List<IdentityDto>> getAllEmployees(){
        List<IdentityDto> identities = identityService.getAllidentities();
        return ResponseEntity.ok(identities);
    }

}
