package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class EmployerRequest {
    private String name;
    private String lastName;
    private String company;
    private LocalDate dateOfBirth;
}
