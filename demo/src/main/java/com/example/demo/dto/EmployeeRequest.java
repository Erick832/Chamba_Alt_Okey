package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class EmployeeRequest {
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<Long>employmentsId;
}
