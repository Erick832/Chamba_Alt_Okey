package com.example.demo.services;

import com.example.demo.common.Validator;
import com.example.demo.dto.AbilityRequest;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.JobApplicationRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entities.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.JobApplicationRepository;
import com.example.demo.repositories.JobOfferRepository;
import com.example.demo.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmploymentServices employmentServices;
    @Autowired
    private AbilityServices abilityServices;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;


    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        Validator.validarEmployee(employeeRequest);
        Validator.validarEmail(employeeRequest.getEmail());
        Validator.validarRepeatedEmail(employeeRepository,employeeRequest.getEmail());
        Validator.validarStrongPassword(employeeRequest.getPassword());

        Employee employee=new Employee();
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPassword(employeeRequest.getPassword());
        Employment employment=employmentServices.createEmployment(employeeRequest.getEmploymentId());
        employee.setEmployment(employment);

        return employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> findAllEmployer(){
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee updateEmployee(Long id,EmployeeRequest employeeRequest){
        Validator.validarEmployee(employeeRequest);
        Validator.validarEmail(employeeRequest.getEmail());
        Validator.validarRepeatedEmail(employeeRepository,employeeRequest.getEmail());
        Validator.validarStrongPassword(employeeRequest.getPassword());


        Employee employee=employeeRepository.findById(id).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPassword(employeeRequest.getPassword());

        Employment employment=employmentServices.createEmployment(employeeRequest.getEmploymentId());
        employee.setEmployment(employment);
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        employeeRepository.delete(employee);
    }

    @Transactional
    public Employee loginEmployee(UserRequest userRequest){
        Validator.validarEmail(userRequest.getEmail());
        if (employeeRepository.existsByEmail(userRequest.getEmail())){
            Employee employee=employeeRepository.findByEmail(userRequest.getEmail());
            if(userRequest.getPassword().equals(employee.getPassword())){
                return employee;
            }
            throw new BadRequestException(ExceptionMessageEnum.PASSWORD_INCORRECT.getMessage());
        }
        throw  new BadRequestException(ExceptionMessageEnum.EMAIL_NOT_FOUND.getMessage());
    }
    @Transactional
    public Employee addAbility(Long id,AbilityRequest abilityRequest){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        List<Ability>abilities=new ArrayList<>();
        for (String text:abilityRequest.getAbilities()) {
            Ability ability = abilityServices.createAbility(text);
            abilities.add(ability);
        }
        employee.setAbilities(abilities);
        return employeeRepository.save(employee);
    }
    @Transactional
    public List<Notification>showNotifications(Long idEmployee){
        Employee employee=employeeRepository.findById(idEmployee).orElseThrow(()->new BadRequestException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        return notificationRepository.queryFiltrarNotificationByNamejob(employee.getEmployment().getName());
    }
    @Transactional
    public Employee getEmployeeById(Long employeeId){
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new BadRequestException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        return employee;

    }

}