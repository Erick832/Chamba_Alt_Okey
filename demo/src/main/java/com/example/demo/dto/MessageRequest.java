package com.example.demo.dto;

import lombok.Data;

@Data
public class MessageRequest {
    private Long idEmployee;
    private Long idEmployer;
    private String message;
}
