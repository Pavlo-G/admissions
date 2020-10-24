package com.training.admissions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }




    @GetMapping("/auth/login")
    public String login(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (error != null) {
            model.addAttribute("errorMessage", "The email or password is incorrect.");
        }
        return "login";

    }

    @GetMapping("/auth/success")
    public String getSuccessPage() {
        return "success";
    }

}
