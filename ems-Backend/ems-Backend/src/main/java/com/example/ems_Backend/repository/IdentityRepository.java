package com.example.ems_Backend.repository;

import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdentityRepository extends JpaRepository<Identity, Integer> {

    void deleteByEmployee(Employee employee);

    List<Identity> findByEmployee(Employee employee);
}
