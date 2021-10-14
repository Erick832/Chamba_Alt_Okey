package com.example.demo.controller;

import com.example.demo.common.EntityDtoConverter;
import com.example.demo.dto.JobRequest;
import com.example.demo.dto.JobResponse;
import com.example.demo.entities.Job;
import com.example.demo.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {
    @Autowired
    private JobServices jobServices;
    @Autowired
    private EntityDtoConverter entityDtoConverter;
    @PostMapping
    public ResponseEntity<JobResponse>createStudent(@RequestBody JobRequest jobRequest){
        Job job = jobServices.createJob(jobRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(job), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<JobResponse>>findAllRecycles(){
        List<Job> jobs = jobServices.findAllJob();
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(jobs),HttpStatus.OK);
    }
    @DeleteMapping("/{idJob}")
    public void deleteJob(@PathVariable String idJob){
        jobServices.deleteJob(Long.valueOf(idJob));
    }
    @PutMapping("/{idJob}")
    public ResponseEntity<JobResponse>updateJob(@PathVariable String idJob,@RequestBody JobRequest jobRequest){
        Job job=jobServices.updateJob(Long.valueOf(idJob),jobRequest);
        return  new ResponseEntity<>(entityDtoConverter.convertEntityToDto(job),HttpStatus.OK);
    }

}
