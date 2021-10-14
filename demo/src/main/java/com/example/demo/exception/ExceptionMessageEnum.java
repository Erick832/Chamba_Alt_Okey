package com.example.demo.exception;

public enum ExceptionMessageEnum {
    JOB_NOT_FOUND("JOB NO ENCONTRADO"), JOB_IS_EMPTY("DATOS INCOMPLETOS");

    private final String message;
    ExceptionMessageEnum(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }

}
