package com.example.demo.common;

import com.example.demo.dto.EmployerRequest;
import com.example.demo.dto.JobRequest;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.BadRequestException;

public class Validator {
    public static boolean validarJob(JobRequest jobRequest){
        if(jobRequest.getNameJob().isEmpty()||jobRequest.getTypeJob().isEmpty()){
            throw new BadRequestException(ExceptionMessageEnum.JOB_IS_EMPTY.getMessage());
        }
        return true;
    }
    public static boolean validarEmployeer(EmployerRequest employerRequest){
        if(employerRequest.getName().isEmpty()||employerRequest.getLastName().isEmpty()){
            throw new BadRequestException(ExceptionMessageEnum.USER_IS_EMPTY.getMessage());
        }
        return true;
    }
}
