package com.example.demo.handler;

import com.example.demo.exception.ExceptionResponse;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Object>handleAllException(Exception exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(),webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response,response.getStatus());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object>handleIncorrectRequest(BadRequestException exception, WebRequest webRequest){
        ExceptionResponse response= new ExceptionResponse(exception.getMessage(),webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(response,response.getStatus());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object>handleNotFound(NotFoundException exception, WebRequest webRequest){
        ExceptionResponse response= new ExceptionResponse(exception.getMessage(),webRequest.getDescription(false),
                HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response,response.getStatus());
    }
}
