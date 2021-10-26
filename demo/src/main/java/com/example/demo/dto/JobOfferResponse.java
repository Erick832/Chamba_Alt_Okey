package com.example.demo.dto;

import com.example.demo.entities.Employer;
import com.example.demo.entities.Employment;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class JobOfferResponse {
    private Long offerIdJob;
    private String description;
    private Date date;
    private String state;
    private Employer employer;
    private Employment employment;
}
