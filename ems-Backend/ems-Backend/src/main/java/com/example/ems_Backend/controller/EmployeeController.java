package com.example.ems_Backend.controller;


import com.example.ems_Backend.dto.EmployeeDto;
import com.example.ems_Backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    //Build add RestAPI
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get employee by iD RestApi
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }


        //Build Get ALl Employee RestApi
    @GetMapping
        public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
            List<EmployeeDto> employees = employeeService.getAllemployees();
            return ResponseEntity.ok(employees);
        }
        //Build Update employee restApi
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedemployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId,updatedemployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build delete employee restApi
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.ok("employee deleted successfully");

    }

    }




