package com.training.admissions.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


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


    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registration";
    }
}
