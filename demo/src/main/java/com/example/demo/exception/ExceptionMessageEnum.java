package com.example.demo.exception;

public enum ExceptionMessageEnum {
    JOB_NOT_FOUND("JOB NO ENCONTRADO"), JOB_IS_EMPTY("DATOS DE JOB INCOMPLETOS"),
    USER_NOT_FOUND("USER NO ENCONTRADO"),USER_IS_EMPTY("DATOS DE USER INCOMPLETOS");

    private final String message;
    ExceptionMessageEnum(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }

}
