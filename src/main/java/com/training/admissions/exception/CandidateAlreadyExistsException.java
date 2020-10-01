package com.training.admissions.exception;

public class CandidateAlreadyExistsException extends Throwable {

    private String message;
    public CandidateAlreadyExistsException(String message) {
        super(message);
    }
}
