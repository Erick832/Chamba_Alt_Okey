package com.example.demo.dto;

import com.example.demo.entities.Job;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<Job>jobs;
}
