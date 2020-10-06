package com.training.admissions.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = CandidateAlreadyExistsException.class)
    public ModelAndView handleCandidateAlreadyExistsException(CandidateAlreadyExistsException ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/registration");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }


    @ExceptionHandler(value = CandidateNotFoundException.class)
    public ModelAndView handleCandidateNotFoundException(CandidateNotFoundException ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/registration");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }




    @ExceptionHandler(value =    FacultyAlreadyExistsException.class)
    public ModelAndView handleConstraintViolationException(   FacultyAlreadyExistsException ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/create-faculty");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value =RequestAlreadyExistsException.class)
    public ModelAndView handleConstraintViolationException( RequestAlreadyExistsException ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/candidate/request_form");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }


}
