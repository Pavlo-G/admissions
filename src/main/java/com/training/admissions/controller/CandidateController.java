package com.training.admissions.controller;


import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.service.CandidateProfileService;
import com.training.admissions.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/api/candidate")
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateProfileService candidateProfileService;

    public CandidateController(CandidateService candidateService, CandidateProfileService candidateProfileService) {
        this.candidateService = candidateService;
        this.candidateProfileService = candidateProfileService;
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
    }


    @GetMapping("/{name}")
    public String getByName(@PathVariable String name, Model model) {
        Candidate candidate = candidateService.findByUsername(name);
        model.addAttribute("candidate", candidate);
        return "/candidate/candidate_profile";

    }

    @GetMapping("/edit/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Candidate candidate = candidateService.getById(id);
        model.addAttribute("candidate", candidate);
        return "/candidate/candidate_profile_edit";

    }



    @PostMapping("/registration")
    public String createCandidate(CandidateDTO userDTO, Model model) {
        try {
            candidateService.createCandidate(userDTO);
        } catch (CandidateAlreadyExistsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "registration";
        }

        log.info("new user " + userDTO.getUsername() + " created!");
        return "redirect:/auth/login";
    }
}


