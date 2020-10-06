package com.training.admissions.controller;


import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.Candidate;
import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller

public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("/faculties")
    public String getAllFaculties(@AuthenticationPrincipal User user, Model model) {
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))){
            return "redirect:/admin/workspace";
        }else {
            model.addAttribute("all_faculties", facultyService.getAllFaculties());
            return "faculties";
        }
    }



}
