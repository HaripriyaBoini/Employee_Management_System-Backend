package com.example.ems_Backend.service.Imp1;


import com.example.ems_Backend.dto.EducationDto;
import com.example.ems_Backend.dto.EmployeeDto;
import com.example.ems_Backend.dto.IdentityDto;
import com.example.ems_Backend.entity.Education;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.entity.Identity;
import com.example.ems_Backend.exception.ResourceNotFoundException;
import com.example.ems_Backend.mapper.EducationMapper;
import com.example.ems_Backend.mapper.EmployeeMapper;
import com.example.ems_Backend.mapper.IdentityMapper;
import com.example.ems_Backend.repository.EducationRepository;
import com.example.ems_Backend.service.EducationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EducationServiceImp1 implements EducationService {
    private EducationRepository educationRepository;

    @Override
    public EducationDto addEducation(EducationDto educationDto) {


        Education education=EducationMapper.maptoEducation(educationDto);
        Education savedEducation=educationRepository.save(education);
        return EducationMapper.mapToEducationDto(savedEducation);

    }




    @Override
    public EducationDto updateEducation(EducationDto updatedEducation, Integer id) {
        Education education=educationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("education not exhist with id"+id));

        education.setYear(updatedEducation.getYear());
        education.setDegree(updatedEducation.getDegree());
        education.setInstitute(updatedEducation.getInstitute());

        Education updated_Educ_Object=educationRepository.save(education);
        return EducationMapper.mapToEducationDto(updated_Educ_Object);


    }
@Override
    @Transactional
    public void deleteEducation(Integer id){
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> findByEmployee(EmployeeDto employeeDto) {

        Employee employee1 = EmployeeMapper.mapToEmployee(employeeDto);
        return educationRepository.findByEmployee(employee1);
    }

    @Override
    public List<EducationDto> getAllEducation() {
        List<Education> all_education=educationRepository.findAll();
        return all_education.stream().map((education)->EducationMapper.mapToEducationDto(education))
                .collect(Collectors.toList());



        }
    }



