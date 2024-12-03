package com.example.ems_Backend.service;

import com.example.ems_Backend.dto.EmployeeDto;
import com.example.ems_Backend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllemployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedemployee);
    void deleteEmployee(Long employeeId);


    Optional<Employee> findById(Integer id);


}
