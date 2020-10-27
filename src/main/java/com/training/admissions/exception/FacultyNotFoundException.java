package com.training.admissions.exception;

public class FacultyNotFoundException extends RuntimeException{
    public FacultyNotFoundException(String message) {
        super(message);
    }
}
