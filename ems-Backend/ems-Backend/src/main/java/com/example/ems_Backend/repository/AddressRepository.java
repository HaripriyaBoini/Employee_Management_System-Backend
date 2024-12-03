package com.example.ems_Backend.repository;

import com.example.ems_Backend.dto.AddressDto;
import com.example.ems_Backend.entity.Address;
import com.example.ems_Backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    void deleteByEmployee(Employee employee);

    List<AddressDto> findByEmployee(Employee employee);
}
