package com.training.admissions.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = CandidateAlreadyExistsException.class)
    public ModelAndView handleCandidateAlreadyExistsException(CandidateAlreadyExistsException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/registration");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }


    @ExceptionHandler(value = CandidateNotFoundException.class)
    public ModelAndView handleCandidateNotFoundException(CandidateNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/errorPage");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }


    @ExceptionHandler(value = FacultyAlreadyExistsException.class)
    public ModelAndView handleFacultyAlreadyExistsException(FacultyAlreadyExistsException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/create-faculty");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = RequestAlreadyExistsException.class)
    public ModelAndView handleRequestAlreadyExistsException(RequestAlreadyExistsException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/candidate/request_form");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = RequestNotFoundException.class)
    public ModelAndView handleRequestNotFoundException(RequestNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/errorPage");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }


    @ExceptionHandler(value = FacultyNotFoundException.class)
    public ModelAndView handleFacultyNotFoundException(FacultyNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/errorPage");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }


    @ExceptionHandler(value = StatementCreationException.class)
    public ModelAndView handleStatementCreationException(StatementCreationException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/errorPage");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

}
