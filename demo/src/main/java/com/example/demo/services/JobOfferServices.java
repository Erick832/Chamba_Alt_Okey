package com.example.demo.services;

import com.example.demo.common.Validator;
import com.example.demo.dto.JobOfferRequest;
import com.example.demo.entities.Employer;
import com.example.demo.entities.Job;
import com.example.demo.entities.JobOffer;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.EmployerRepository;
import com.example.demo.repositories.JobOfferRepository;
import com.example.demo.repositories.JobRepository;
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
    private JobRepository jobRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public JobOffer createJobOffer(JobOfferRequest jobOfferRequest) {
        Validator.validarJobOffer(jobOfferRequest);
        Employer employer=employerRepository.findById(jobOfferRequest.getEmployerId()).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        JobOffer jobOffer=new JobOffer();
        List<Job>jobs=new ArrayList<>();
        jobOffer.setDescription(jobOfferRequest.getDescription());
        jobOffer.setDate(new Date());
        jobOffer.setEmployer(employer);
        for (Long jobId:jobOfferRequest.getIdJobs()){
            Job job=jobRepository.findById(jobId).orElseThrow(()->new NotFoundException(ExceptionMessageEnum.JOB_NOT_FOUND.getMessage()));
            jobs.add(job);
        }
        jobOffer.setJobs(jobs);
        return jobOfferRepository.save(jobOffer);
    }
    @Transactional
    public List<JobOffer>findAllJobOffer(){
        return jobOfferRepository.findAll();
    }

}
