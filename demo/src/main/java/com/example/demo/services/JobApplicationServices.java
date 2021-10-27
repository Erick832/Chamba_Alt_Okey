package com.example.demo.services;

import com.example.demo.dto.JobApplicationRequest;
import com.example.demo.entities.Employee;
import com.example.demo.entities.JobApplication;
import com.example.demo.entities.JobOffer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.JobApplicationRepository;
import com.example.demo.repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobApplicationServices {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Transactional
    public JobApplication createJobApplication(JobApplicationRequest jobApplicationRequest){
        Employee employee=employeeRepository.findById(jobApplicationRequest.getEmployeeId()).orElseThrow(()->new BadRequestException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        JobOffer jobOffer=jobOfferRepository.findById(jobApplicationRequest.getJobOfferId()).orElseThrow(()->new BadRequestException(ExceptionMessageEnum.JOB_OFFER_NOT_FOUND.getMessage()));
        JobApplication jobApplication=new JobApplication();
        jobApplication.setEmployeeId(jobApplicationRequest.getEmployeeId());
        jobApplication.setJobOfferId(jobApplicationRequest.getJobOfferId());
        jobApplication.setMessage(jobApplicationRequest.getMessage());
        return jobApplicationRepository.save(jobApplication);
    }
    public List<JobApplication>getAllJobApplications(){
        return jobApplicationRepository.findAll();
    }
    public List<JobApplication>findJobApplicationsByJobOfferId(Long jobOfferId){
        return jobApplicationRepository.findAllByJobOfferId(jobOfferId);
    }
}
