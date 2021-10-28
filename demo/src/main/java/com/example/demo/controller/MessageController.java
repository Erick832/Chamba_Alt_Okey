package com.example.demo.controller;

import com.example.demo.common.EntityDtoConverter;
import com.example.demo.dto.MessageRequest;
import com.example.demo.dto.MessageResponse;
import com.example.demo.entities.Message;
import com.example.demo.services.JobOfferServices;
import com.example.demo.services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {
    @Autowired
    private EntityDtoConverter entityDtoConverter;
    @Autowired
    private MessageServices messageServices;
    @PostMapping
    public ResponseEntity<MessageResponse>createMessage(@RequestBody MessageRequest messageRequest){
        Message message= messageServices.createMessage(messageRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(message), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MessageResponse>>findAllMessages(){
        List<Message> messages=messageServices.findAllMessage();
        return new ResponseEntity<>(entityDtoConverter.convertMessagesToDto(messages),HttpStatus.OK);
    }

}
