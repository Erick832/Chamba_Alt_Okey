package com.example.demo.common;

import com.example.demo.dto.JobResponse;
import com.example.demo.entities.Job;
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

    public List<JobResponse>convertEntityToDto(List<Job> jobs){
        return jobs.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

}
