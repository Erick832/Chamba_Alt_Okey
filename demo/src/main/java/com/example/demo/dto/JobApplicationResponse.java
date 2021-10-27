package com.example.demo.dto;

import lombok.Data;

@Data
public class JobApplicationResponse {
    private Long id;
    private Long employeeId;
    private Long jobOfferId;
    private String message;
}
