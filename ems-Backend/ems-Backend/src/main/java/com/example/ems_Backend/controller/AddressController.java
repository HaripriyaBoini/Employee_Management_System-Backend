package com.example.ems_Backend.controller;


import com.example.ems_Backend.dto.AddressDto;
import com.example.ems_Backend.dto.EducationDto;
import com.example.ems_Backend.dto.EmployeeDto;
import com.example.ems_Backend.entity.Address;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.mapper.AddressMapper;
import com.example.ems_Backend.mapper.EmployeeMapper;
import com.example.ems_Backend.service.AddressService;
import com.example.ems_Backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.ems_Backend.mapper.AddressMapper.mapToAddressDto;

@RestController
@AllArgsConstructor
public class AddressController {

@Autowired
    public AddressService addressService;
@Autowired
    private EmployeeService employeeService;


    @PostMapping("/employee/{empId}/address")   //for add
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto,@PathVariable Integer empId){


              Employee employee=new Employee();
        AddressDto saved_address=addressService.addAddress(addressDto,employee);

        return  new ResponseEntity<>(saved_address, HttpStatus.CREATED);
    }


    @PutMapping("address/{id}")
    public ResponseEntity<AddressDto> update_Address(@PathVariable Integer id,@RequestBody AddressDto addressDto){
        AddressDto updated_address = addressService.updateAddress(addressDto,id);
        return new ResponseEntity<>(updated_address, HttpStatus.CREATED);

    }

    @GetMapping("address/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable Integer id) {
        Address get_address = addressService.getAddress(id);

        AddressDto add_Dto = mapToAddressDto(get_address);
        return ResponseEntity.ok(add_Dto);
    }

@DeleteMapping("address/{id}")
        public ResponseEntity<String> deleteAddress(Integer id){
            addressService.deleteAddress(id);
            return new ResponseEntity<>("address with id deleted succesfully",HttpStatus.OK);
        }

@GetMapping("/address")
    public ResponseEntity<List<AddressDto>> getAllAdresses(){
    List<AddressDto> address=addressService.getAllAddresses();
    return ResponseEntity.ok(address);
}




}


