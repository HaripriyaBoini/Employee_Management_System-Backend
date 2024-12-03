package com.example.ems_Backend.repository;

import com.example.ems_Backend.entity.Education;
import com.example.ems_Backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Integer> {
    List<Education> findByEmployee(Employee employee);

}
