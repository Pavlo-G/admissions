package com.training.admissions.controller;


import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.dto.CandidateProfileDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.model.CandidateProfile;
import com.training.admissions.service.CandidateProfileService;
import com.training.admissions.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateProfileService candidateProfileService;

    public CandidateController(CandidateService candidateService, CandidateProfileService candidateProfileService) {
        this.candidateService = candidateService;
        this.candidateProfileService = candidateProfileService;
    }


    @DeleteMapping("/api/candidate/{id}")
    public void deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
    }


    @GetMapping("/api/candidate/profile")
    public String getCandidateProfile(@AuthenticationPrincipal User currentUser
            , Model model) {
        model.addAttribute("candidate", candidateService.findByUsername(currentUser.getUsername()));
        return "/candidate/candidate_profile";
    }

    @GetMapping("/api/candidate/edit/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Candidate candidate = candidateService.getById(id);
        model.addAttribute("candidate", candidate);
        return "/candidate/candidate_profile_edit";

    }


    @PostMapping("/api/candidate/registration")
    public String createCandidate(CandidateDTO candidateDTO, CandidateProfileDTO candidateProfileDTO, Model model) {

        Candidate candidate = candidateService.createCandidate(candidateDTO);
        candidateProfileService.createCandidateProfile(candidateProfileDTO, candidate.getId());
        log.info("new user " + candidateDTO.getUsername() + " created!");

        return "redirect:/auth/login";
    }




    @PostMapping("/api/candidate/update")
    public String updateCandidate(CandidateProfileDTO candidateProfileDTO
            , CandidateDTO candidateDTO, Model model) {
        candidateProfileService.updateCandidateProfile(candidateProfileDTO);
        return "redirect:/api/candidate/profile";
    }


}


