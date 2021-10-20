package com.example.demo.common;

import com.example.demo.dto.EmployerResponse;
import com.example.demo.dto.JobOfferResponse;
import com.example.demo.dto.JobResponse;
import com.example.demo.entities.Employer;
import com.example.demo.entities.Job;
import com.example.demo.entities.JobOffer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public JobResponse convertEntityToDto(Job job){
        return modelMapper.map(job, JobResponse.class);
    }

    public List<JobResponse>convertEntityToDto(List<Job>jobs){
        return jobs.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EmployerResponse convertEntityToDto(Employer employer){
        return modelMapper.map(employer, EmployerResponse.class);
    }
    public List<EmployerResponse>convertEmployersToDto(List<Employer> employers){
        return employers.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public JobOfferResponse convertEntityToDto(JobOffer jobOffer){
        return modelMapper.map(jobOffer,JobOfferResponse.class);
    }
    public List<JobOfferResponse>convertJobOffersToDto(List<JobOffer>jobOffers){
        return jobOffers.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


}
