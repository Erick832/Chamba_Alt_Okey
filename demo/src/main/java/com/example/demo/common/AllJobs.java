package com.example.demo.common;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ExceptionMessageEnum;
import lombok.Data;

@Data
public class AllJobs {
    private String name;
    private String type;
    public AllJobs(Long IdEmployment){
        if(IdEmployment.intValue()==1)
        {
            this.name="Carpintero";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==2){
            this.name="Plomero";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==3){
            this.name="Pescador";
            this.type="Oficio";
        }
        else {
            throw new BadRequestException(ExceptionMessageEnum.JOB_NOT_FOUND.getMessage());
        }
    }
}
