package com.example.demo.dto;

import lombok.Data;


@Data
public class EmployerResponse {
    private Long id;
    private String name;
    private String lastName;
    private String company;
    private String dateOfBirth;
}
