package com.example.demo.dto;

import lombok.Data;

import java.util.Date;
@Data
public class NotificationResponse {
    private Long id;
    private String message;
    private Date date;
}
