package com.training.admissions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }



    @RequestMapping("/all_faculties")
    public String getFacultiesPage() {
        return "faculties";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (error != null) {
            model.addAttribute("errorMessage", "The email or password is incorrect.");
        }
        return "registration";
    }


    @GetMapping("/registration/details")
    public String getRegistrationDetailsPage() {
        return "/candidate/reg_details";
    }



}
