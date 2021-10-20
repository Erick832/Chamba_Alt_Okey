package com.example.demo.controller;

import com.example.demo.common.EntityDtoConverter;
import com.example.demo.dto.JobOfferRequest;
import com.example.demo.dto.JobOfferResponse;
import com.example.demo.entities.JobOffer;
import com.example.demo.services.JobOfferServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobOffers")
public class JobOfferController {
    @Autowired
    private EntityDtoConverter entityDtoConverter;
    @Autowired
    private JobOfferServices jobOfferServices;
    @PostMapping
    public ResponseEntity<JobOfferResponse>createJobOffer(@RequestBody JobOfferRequest jobOfferRequest){
        JobOffer jobOffer=jobOfferServices.createJobOffer(jobOfferRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(jobOffer), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<JobOfferResponse>>findAllOfferJobOffer(){
        List<JobOffer> jobOffers=jobOfferServices.findAllJobOffer();
        return new ResponseEntity<>(entityDtoConverter.convertJobOffersToDto(jobOffers),HttpStatus.OK);
    }
}
