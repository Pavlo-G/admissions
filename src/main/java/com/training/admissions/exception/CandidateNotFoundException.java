package com.training.admissions.exception;

public class CandidateNotFoundException extends RuntimeException {
    private String message;

    public CandidateNotFoundException(String message) {

        this.message=message;
    }
}
