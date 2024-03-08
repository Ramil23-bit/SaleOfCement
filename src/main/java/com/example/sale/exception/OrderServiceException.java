package com.example.sale.exception;

public class OrderServiceException extends RuntimeException{

    public OrderServiceException(String message){
        super(message);
    }
}
