package com.training.admissions.exception;

public class FacultyAlreadyExistsException extends RuntimeException {
    public FacultyAlreadyExistsException(String message) {
        super(message);
    }
}
