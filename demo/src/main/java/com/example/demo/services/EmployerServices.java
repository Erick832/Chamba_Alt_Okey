package com.example.demo.services;

import com.example.demo.common.Validator;
import com.example.demo.dto.EmployerRequest;
import com.example.demo.entities.Employer;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
@Service
public class EmployerServices {
    @Autowired
    private EmployerRepository employerRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public Employer createEmployer(EmployerRequest employerRequest) {
        Validator.validarEmployeer(employerRequest);
        Employer employer=new Employer();
        employer.setName(employerRequest.getName());
        employer.setLastName(employerRequest.getLastName());
        employer.setCompany(employerRequest.getCompany());
        employer.setDateOfBirth(employerRequest.getDateOfBirth());

        return employerRepository.save(employer);
    }

    @Transactional
    public List<Employer>findAllEmployer(){
        return employerRepository.findAll();
    }

    @Transactional
    public void deleteEmployer(Long id){
        Employer employer=employerRepository.findById(id).
                orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        employerRepository.delete(employer);
    }
    @Transactional
    public Employer updateEmployer(Long id,EmployerRequest employerRequest){
        Employer employer=employerRepository.findById(id).
                orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        employer.setName(employerRequest.getName());
        employer.setLastName(employerRequest.getLastName());
        employer.setCompany(employerRequest.getCompany());
        employer.setDateOfBirth(employerRequest.getDateOfBirth());
        return employerRepository.save(employer);
    }

}
