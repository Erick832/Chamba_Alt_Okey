package com.example.demo.exception;

public enum ExceptionMessageEnum {
    JOB_NOT_FOUND("JOB NO ENCONTRADO"), JOB_IS_EMPTY("DATOS DE JOB INCOMPLETOS"),
    USER_NOT_FOUND("USER NO ENCONTRADO"),USER_IS_EMPTY("DATOS DE USER INCOMPLETOS"),
    JOB_OFFER_NOT_FOUND("JOB_OFFER NOT FOUND"),JOB_OFFER_IS_EMPTY("DATOS DE JOB OFFER INCOMPLETOS");

    private final String message;
    ExceptionMessageEnum(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }

}
