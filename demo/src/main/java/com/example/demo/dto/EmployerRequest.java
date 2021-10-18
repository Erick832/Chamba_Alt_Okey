package com.example.demo.dto;

import lombok.Data;




@Data
public class EmployerRequest {
    private String name;
    private String lastName;
    private String company;
    private String dateOfBirth;
}
