package com.example.demo.services;

import com.example.demo.common.Validator;
import com.example.demo.dto.EmployerRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Employer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployerServices {
    @Autowired
    private EmployerRepository employerRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public Employer createEmployer(EmployerRequest employerRequest) {
        Validator.validarEmployeer(employerRequest);
        Validator.validarEmail(employerRequest.getEmail());
        Validator.validarStrongPassword(employerRequest.getPassword());
        Validator.validadRepeatEmailEmployer(employerRepository,employerRequest.getEmail());

        Employer employer=new Employer();
        employer.setName(employerRequest.getName());
        employer.setLastName(employerRequest.getLastName());
        employer.setCompany(employerRequest.getCompany());
        employer.setDateOfBirth(employerRequest.getDateOfBirth());
        employer.setEmail(employerRequest.getEmail());
        employer.setPassword(employerRequest.getPassword());

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
        Validator.validarEmployeer(employerRequest);
        Validator.validarEmail(employerRequest.getEmail());
        Validator.validarStrongPassword(employerRequest.getPassword());
        Validator.validadRepeatEmailEmployer(employerRepository,employerRequest.getEmail());
        Employer employer=employerRepository.findById(id).
                orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        employer.setName(employerRequest.getName());
        employer.setLastName(employerRequest.getLastName());
        employer.setCompany(employerRequest.getCompany());
        employer.setDateOfBirth(employerRequest.getDateOfBirth());

        employer.setEmail(employerRequest.getEmail());
        employer.setPassword(employerRequest.getPassword());
        return employerRepository.save(employer);
    }

    @Transactional
    public Employer loginEmployer(UserRequest userRequest){
        Validator.validarEmail(userRequest.getEmail());
        if (employerRepository.existsByEmail(userRequest.getEmail())){
            Employer employer=employerRepository.findByEmail(userRequest.getEmail());
            if(userRequest.getPassword().equals(employer.getPassword())){
                return employer;
            }
            throw new BadRequestException(ExceptionMessageEnum.PASSWORD_INCORRECT.getMessage());
        }
        throw  new BadRequestException(ExceptionMessageEnum.EMAIL_NOT_FOUND.getMessage());
    }
}