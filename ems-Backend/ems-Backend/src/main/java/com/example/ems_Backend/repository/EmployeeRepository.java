package com.example.ems_Backend.repository;

import com.example.ems_Backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Optional<Employee> findById(Long id);
}
