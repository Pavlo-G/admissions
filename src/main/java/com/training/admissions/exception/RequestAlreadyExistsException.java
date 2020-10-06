package com.training.admissions.exception;

public class RequestAlreadyExistsException  extends RuntimeException{


    public RequestAlreadyExistsException(String message) {
        super(message);
    }
}
