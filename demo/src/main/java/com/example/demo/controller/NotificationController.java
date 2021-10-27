package com.example.demo.controller;

import com.example.demo.common.EntityDtoConverter;
import com.example.demo.dto.NotificationResponse;
import com.example.demo.entities.Notification;
import com.example.demo.services.NotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("notification")
public class NotificationController {
    @Autowired
    private NotificationServices notificationServices;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @GetMapping
    public ResponseEntity<List<NotificationResponse>>findAllNotification(){
        List<Notification>notifications=notificationServices.findAllNotification();
        return new ResponseEntity<>(entityDtoConverter.convertNotificationsToDto(notifications), HttpStatus.OK);
    }
}
