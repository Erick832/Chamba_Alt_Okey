package com.example.demo.services;

import com.example.demo.common.Validator;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Job;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        Validator.validarEmployee(employeeRequest);
        Employee employee=new Employee();
        List<Job>jobs=new ArrayList<>();
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        for (Long jobId:employeeRequest.getJobsId()){
            Job job=jobRepository.findById(jobId).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.JOB_NOT_FOUND.getMessage()));
            jobs.add(job);
        }
        employee.setJobs(jobs);
        return employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> findAllEmployer(){
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee updateEmployee(Long id,EmployeeRequest employeeRequest){
        Validator.validarEmployee(employeeRequest);
        List<Job>jobs=new ArrayList<>();
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        for(Long idJob:employeeRequest.getJobsId()){
            Job job=jobRepository.findById(idJob).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.JOB_NOT_FOUND.getMessage()));
            jobs.add(job);
        }
        employee.setJobs(jobs);
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        employeeRepository.delete(employee);
    }


}
