package com.example.demo.common;

import com.example.demo.dto.JobRequest;
import com.example.demo.exception.ExceptionMessageEnum;
import com.example.demo.exception.RecycleBadRequestException;

public class JobValidator {
    public static boolean validarJob(JobRequest jobRequest){
        if(jobRequest.getNameJob().isEmpty()||jobRequest.getTypeJob().isEmpty()){
            throw new RecycleBadRequestException(ExceptionMessageEnum.JOB_IS_EMPTY.getMessage());
        }
        return true;
    }
}
