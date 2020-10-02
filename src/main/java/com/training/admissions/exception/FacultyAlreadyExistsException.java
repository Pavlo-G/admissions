package com.training.admissions.exception;

public class FacultyAlreadyExistsException extends RuntimeException {
    private String message;

    public FacultyAlreadyExistsException(String message) {
        this.message = message;
    }
}
