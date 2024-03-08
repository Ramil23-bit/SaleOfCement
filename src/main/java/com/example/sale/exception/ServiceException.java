package com.example.sale.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String message){
        super(message);
    }
}
