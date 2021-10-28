package com.example.demo.dto;

import lombok.Data;

@Data
public class MessageResponse {
    private Long id;
    private Long idEmployee;
    private Long idEmployer;
    private String message;
}
