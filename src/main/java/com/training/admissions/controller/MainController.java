package com.training.admissions.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;
import java.util.ResourceBundle;


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
            Locale locale = LocaleContextHolder.getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
            model.addAttribute("errorMessage", bundle.getObject("login.or.password.error"));
        }
        return "login";

    }

    @GetMapping("/auth/success")
    public String getSuccessPage() {
        return "success";
    }

}
