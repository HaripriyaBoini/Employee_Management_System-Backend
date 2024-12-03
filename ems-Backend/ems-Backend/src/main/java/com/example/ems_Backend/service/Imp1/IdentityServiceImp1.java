package com.example.ems_Backend.service.Imp1;

import com.example.ems_Backend.dto.IdentityDto;
import com.example.ems_Backend.entity.Employee;
import com.example.ems_Backend.entity.Identity;
import com.example.ems_Backend.exception.ResourceNotFoundException;
import com.example.ems_Backend.mapper.EmployeeMapper;
import com.example.ems_Backend.mapper.IdentityMapper;
import com.example.ems_Backend.repository.IdentityRepository;
import com.example.ems_Backend.service.IdentityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class IdentityServiceImp1 implements IdentityService {
@Autowired
    private IdentityRepository identityRepository;

    @Override
    public List<IdentityDto> getAllidentities() {
        List<Identity> identities=identityRepository.findAll();
        return identities.stream().map((identity)-> IdentityMapper.mapToIdentityDto(identity))
                .collect(Collectors.toList());

    }

    @Override
    public IdentityDto addIdentity(IdentityDto identityDto, Employee employee) {

    Identity identity = IdentityMapper.mapToIdentity(identityDto);
        identity.setEmployee(employee);

    Identity savedIdentity = identityRepository.save(identity);
    return IdentityMapper.mapToIdentityDto(savedIdentity);
}










    @Override
    public IdentityDto updateIdentity(IdentityDto identityDto, Integer id) {
        Identity identity_id=identityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("identity not exhist with id"+id));
        Identity identity=IdentityMapper.mapToIdentity(identityDto);
        Identity saved_identity=identityRepository.save(identity);
        return IdentityMapper.mapToIdentityDto(saved_identity);
    }


    @Override
    @Transactional
    public void deleteIdentity(Integer id) {
        identityRepository.deleteById(id);

    }



    @Override
    public void deleteByEmployee(Employee employee) {
        identityRepository.deleteByEmployee(employee);

    }

    @Override
    public List<Identity> findByEmployee(Employee employee) {
        return identityRepository.findByEmployee(employee);
    }
}
