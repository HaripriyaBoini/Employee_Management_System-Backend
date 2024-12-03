package com.example.ems_Backend.service;

import com.example.ems_Backend.dto.IdentityDto;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.entity.Identity;

import java.util.List;

public interface IdentityService {

    public  List<IdentityDto> getAllidentities();


    public IdentityDto addIdentity(IdentityDto identityDto, Employee employee);

    public IdentityDto updateIdentity(IdentityDto identityDto, Integer id);

    public void deleteIdentity(Integer id);


    //delete by employee
    public void deleteByEmployee(Employee employee);

    //find by employee
    public List<Identity> findByEmployee(Employee employee);



}
