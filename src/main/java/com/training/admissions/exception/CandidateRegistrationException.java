package com.training.admissions.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class CandidateRegistrationException extends RuntimeException{
    List<ObjectError> errors;
    public CandidateRegistrationException(String message, List<ObjectError> errors) {
        super(message);
        this.errors=errors;
    }




}
