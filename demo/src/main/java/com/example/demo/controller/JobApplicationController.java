package com.example.demo.controller;

import com.example.demo.common.EntityDtoConverter;
import com.example.demo.dto.JobApplicationRequest;
import com.example.demo.dto.JobApplicationResponse;
import com.example.demo.entities.JobApplication;
import com.example.demo.services.JobApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobApplications")
public class JobApplicationController {
    @Autowired
    private JobApplicationServices jobApplicationServices;
    @Autowired
    private EntityDtoConverter entityDtoConverter;
    @PostMapping
    public ResponseEntity<JobApplicationResponse> createNotifications(@RequestBody JobApplicationRequest jobApplicationRequest){
        JobApplication jobApplication = jobApplicationServices.createJobApplication(jobApplicationRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(jobApplication), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<JobApplicationResponse>>findAllJobApplications(){
        List<JobApplication>jobApplications = jobApplicationServices.getAllJobApplications();
        return new ResponseEntity<>(entityDtoConverter.convertJobApplicationsToDto(jobApplications), HttpStatus.OK);
    }
    @GetMapping("/{idJobOffer}")
    public ResponseEntity<List<JobApplicationResponse>>findAllJobApplicationsByJobOfferId(@PathVariable Long idJobOffer){
        List<JobApplication>jobApplications=jobApplicationServices.findJobApplicationsByJobOfferId(idJobOffer);
        return new ResponseEntity<>(entityDtoConverter.convertJobApplicationsToDto(jobApplications),HttpStatus.OK);
    }

}
