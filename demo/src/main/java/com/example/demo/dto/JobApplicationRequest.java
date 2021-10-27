package com.example.demo.dto;

import lombok.Data;

@Data
public class JobApplicationRequest {
    private Long employeeId;
    private Long jobOfferId;
    private String message;
}
