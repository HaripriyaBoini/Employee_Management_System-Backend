package com.example.ems_Backend.service.Imp1;

import com.example.ems_Backend.dto.EmployeeDto;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.exception.ResourceNotFoundException;
import com.example.ems_Backend.repository.EmployeeRepository;
import com.example.ems_Backend.service.EmployeeService;



import com.example.ems_Backend.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImp1 implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee=employeeRepository.findById(employeeId).
                orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exhists with the given Id:"+employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllemployees() {
       List<Employee> employees=employeeRepository.findAll();
       return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
               .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedemployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not exhists with id"+employeeId));

        employee.setFirstName(updatedemployee.getFirstName());
        employee.setLastName(updatedemployee.getLastName());
        employee.setEmail(updatedemployee.getEmail());

        Employee updatedEmployeeobj=employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeobj);




    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("employee is not exhists with id:"+employeeId));
        employeeRepository.deleteById(employeeId);
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(Long.valueOf(id));
    }


}


