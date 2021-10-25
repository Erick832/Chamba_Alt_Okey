package com.example.demo.services;

import com.example.demo.common.Validator;
import com.example.demo.dto.JobRequest;
import com.example.demo.entities.Job;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServices {
    @Autowired
    private JobRepository jobRepository;


    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public Job createJob(JobRequest jobRequest){
        Validator.validarJob(jobRequest);
        Job job =new Job();
        job.setNameJob(jobRequest.getNameJob());
        job.setTypeJob(jobRequest.getTypeJob());
        return jobRepository.save(job);
    }

    @Transactional(readOnly = true)
    public List<Job>findAllJob(){
        return jobRepository.findAll();
    }

    @Transactional
    public void deleteJob(Long id){
        Job job = jobRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ExceptionMessageEnum.JOB_NOT_FOUND.getMessage()));
        jobRepository.delete(job);
    }
    @Transactional
    public Job updateJob(Long id,JobRequest jobRequest){
        Validator.validarJob(jobRequest);
        Job job = jobRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ExceptionMessageEnum.JOB_NOT_FOUND.getMessage()));
        job.setNameJob(jobRequest.getNameJob());
        job.setTypeJob(jobRequest.getTypeJob());
        return jobRepository.save(job);
    }
}
