package com.example.demo.common;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployerRequest;
import com.example.demo.dto.JobOfferRequest;

import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repositories.EmployeeRepository;

public class Validator {

    public static boolean validarEmployeer(EmployerRequest employerRequest){
        if(employerRequest.getName().isEmpty()||employerRequest.getLastName().isEmpty()){
            throw new BadRequestException(ExceptionMessageEnum.USER_IS_EMPTY.getMessage());
        }
        return true;
    }
    public static boolean validarJobOffer(JobOfferRequest jobOfferRequest){
        if (jobOfferRequest.getDescription().isEmpty()||jobOfferRequest.getEmployerId()==null){
            throw new BadRequestException(ExceptionMessageEnum.JOB_OFFER_IS_EMPTY.getMessage());
        }
        return true;
    }
    public static boolean validarEmployee(EmployeeRequest employeeRequest){
        if(employeeRequest.getName().isEmpty()||employeeRequest.getLastName().isEmpty()){
            throw new BadRequestException(ExceptionMessageEnum.USER_IS_EMPTY.getMessage());
        }
        return true;
    }
    public static boolean validarRepeatedEmail(EmployeeRepository employeeRepository,String Email){
        if(employeeRepository.existsByEmail(Email)){
            throw new BadRequestException(ExceptionMessageEnum.EMAIL_REPEATED.getMessage());
        }
        return true;
    }
    public static boolean validarEmail(String email){
        if(email.contains(".com")&&email.contains("@")){
           return true;
        }
        throw new BadRequestException(ExceptionMessageEnum.FORMAT_EMAIL_INCORRECT.getMessage());
    }
    public static boolean validarStrongPassword(String password){
        if(password.length()>8){
            boolean mayuscula=false;
            boolean numero=false;
            char c;
            for(int i=0;i<password.length();i++){
                c=password.charAt(i);
                if(Character.isDigit(c))
                    numero=true;
                if(Character.isUpperCase(c))
                    mayuscula=true;
            }
            if (numero&&mayuscula){
                return true;
            }
            else
                throw  new BadRequestException(ExceptionMessageEnum.NOT_SECURE_PASSWORD.getMessage());
        }
        throw new BadRequestException(ExceptionMessageEnum.NOT_SECURE_PASSWORD.getMessage());
    }
}
