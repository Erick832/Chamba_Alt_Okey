package com.example.demo.dto;

import lombok.Data;

import java.util.List;
@Data
public class JobOfferRequest {
    private Long employerId;
    private String description;
    private List<Long>employmentsId;
}
