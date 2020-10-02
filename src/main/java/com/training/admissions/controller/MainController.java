package com.training.admissions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage(){


        return "index";
    }

    @GetMapping("/candidates")
    public String getCandidatesPage(){
        return "candidates";
    }

    @RequestMapping("/all_faculties")
    public String userPage(){
        return "faculties.html";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registration";
    }
}
