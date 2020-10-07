package com.training.admissions.controller;


import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String getAllFaculties( @PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC, size = 5) Pageable pageable,
            @AuthenticationPrincipal User user, Model model) {
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))){
            return "redirect:/admin/workspace";
        }else {
            Page<Faculty> page =facultyService.getAllFaculties(pageable);
            model.addAttribute("page", page);
            model.addAttribute("url", "/faculties");
            return "faculties";
        }
    }




}
