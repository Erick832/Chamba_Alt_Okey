package com.example.demo.services;

import com.example.demo.dto.MessageRequest;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Employer;
import com.example.demo.entities.Message;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.EmployerRepository;
import com.example.demo.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServices {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployerRepository employerRepository;

    @Transactional
    public Message createMessage(MessageRequest messageRequest){
        Employee employee=employeeRepository.findById(messageRequest.getIdEmployee()).orElseThrow(()->new BadRequestException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        Employer employer=employerRepository.findById(messageRequest.getIdEmployer()).orElseThrow(()->new BadRequestException(ExceptionMessageEnum.USER_NOT_FOUND.getMessage()));
        Message message=new Message();
        message.setIdEmployee(messageRequest.getIdEmployee());
        message.setIdEmployer(messageRequest.getIdEmployer());
        message.setMessage(messageRequest.getMessage());
        return messageRepository.save(message);
    }
    @Transactional
    public List<Message> findAllMessage(){
        return messageRepository.findAll();
    }
}
