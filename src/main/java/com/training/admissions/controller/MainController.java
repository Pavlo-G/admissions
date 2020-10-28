package com.training.admissions.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String login(Model model, HttpServletRequest request,
                        @RequestParam(value = "error", required = false) Boolean error) {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        if (error != null) {
            HttpSession session = request.getSession(false);
            String errorMessage = null;
            if (session != null) {
                AuthenticationException ex = (AuthenticationException) session
                        .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
                if (ex != null) {
                    if (ex instanceof BadCredentialsException) {
                        errorMessage = (String) bundle.getObject("badCredentials");
                    }
                    if (ex instanceof LockedException) {
                        errorMessage = (String) bundle.getObject("disabled");
                    }
                }
            }
            model.addAttribute("errorMessage", errorMessage);
            return "login";

        }
        return "login";
    }
    @GetMapping("/auth/success")
    public String getSuccessPage() {
        return "success";
    }

}
