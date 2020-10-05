package com.training.admissions.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) Boolean error){
        log.info("/login GET method");
        if (error != null) {
            model.addAttribute("errorMessage", "The email or password is incorrect.");
        }
        log.info("/login GET method. error = "+error);
        return "login";

    }
    @GetMapping("/success")
    public String getSuccessPage(){
        return "success";
    }

}
