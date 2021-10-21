package com.example.demo.services;

import com.example.demo.common.Validator;
import com.example.demo.dto.JobOfferRequest;
import com.example.demo.entities.Employer;
import com.example.demo.entities.Employment;
import com.example.demo.entities.JobOffer;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.EmployerRepository;
import com.example.demo.repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobOfferServices {
    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmploymentServices employmentServices;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public JobOffer createJobOffer(JobOfferRequest jobOfferRequest) {
        Validator.validarJobOffer(jobOfferRequest);

        Employer employer=employerRepository.findById(jobOfferRequest.getEmployerId()).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        JobOffer jobOffer=new JobOffer();
        jobOffer.setDescription(jobOfferRequest.getDescription());
        jobOffer.setDate(new Date());
        jobOffer.setEmployer(employer);
        List<Employment>employments=new ArrayList<>();
        for (Long employmentId:jobOfferRequest.getEmploymentsId()){
            Employment employment=employmentServices.createEmployer(employmentId);
            employments.add(employment);
        }
        jobOffer.setEmployments(employments);

        return jobOfferRepository.save(jobOffer);
    }
    @Transactional
    public List<JobOffer>findAllJobOffer(){
        return jobOfferRepository.findAll();
    }

    @Transactional
    public void deleteJobOffer(Long id){
        JobOffer jobOffer=jobOfferRepository.findById(id).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.JOB_OFFER_NOT_FOUND.getMessage()));
        jobOfferRepository.delete(jobOffer);
    }
    @Transactional
    public JobOffer updateJobOffer(Long id, JobOfferRequest jobOfferRequest){
        Validator.validarJobOffer(jobOfferRequest);
        JobOffer jobOffer=jobOfferRepository.findById(id).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.JOB_OFFER_NOT_FOUND.getMessage()));
        Employer employer=employerRepository.findById(jobOfferRequest.getEmployerId()).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        jobOffer.setEmployer(employer);
        jobOffer.setDescription(jobOfferRequest.getDescription());
        jobOffer.setDate(new Date());
        List<Employment>employments=new ArrayList<>();
        for (Long employmentId:jobOfferRequest.getEmploymentsId()){
            Employment employment=employmentServices.createEmployer(employmentId);
            employments.add(employment);
        }
        jobOffer.setEmployments(employments);

        return jobOfferRepository.save(jobOffer);
    }

}
