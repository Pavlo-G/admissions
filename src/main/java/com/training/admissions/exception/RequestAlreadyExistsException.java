package com.training.admissions.exception;

public class RequestAlreadyExistsException  extends RuntimeException{


    private String message;

    public RequestAlreadyExistsException(String message) {
        this.message = message;
    }
}
