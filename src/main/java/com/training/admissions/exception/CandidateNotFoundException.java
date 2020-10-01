package com.training.admissions.exception;

public class CandidateNotFoundException extends Throwable {
    private String message;

    public CandidateNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
