package com.training.admissions.exception;

public class FacultyNotFoundException extends RuntimeException{
    private String message;

    public FacultyNotFoundException(String message) {
        this.message = message;
    }
}
