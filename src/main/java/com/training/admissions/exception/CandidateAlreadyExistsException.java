package com.training.admissions.exception;

public class CandidateAlreadyExistsException extends RuntimeException{

    private String message;

    public CandidateAlreadyExistsException(String message) {

        this.message = message;
    }
}
