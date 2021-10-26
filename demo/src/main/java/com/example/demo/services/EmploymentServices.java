package com.example.demo.services;

import com.example.demo.common.AllJobs;
import com.example.demo.entities.Employment;
import com.example.demo.repositories.EmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmploymentServices {
    @Autowired
    private EmploymentRepository employmentRepository;
    public Employment createEmployment(Long id){
        AllJobs allJobs=new AllJobs(id);
        Employment employment=new Employment();
        employment.setName(allJobs.getName());
        employment.setType(allJobs.getType());
        return employmentRepository.save(employment);
    }
}
