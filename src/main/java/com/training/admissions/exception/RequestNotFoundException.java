package com.training.admissions.exception;


public class RequestNotFoundException extends RuntimeException {

    private String message;

    public RequestNotFoundException(String message) {
        this.message = message;
    }
}