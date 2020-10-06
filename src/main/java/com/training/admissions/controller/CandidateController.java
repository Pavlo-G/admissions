package com.training.admissions.controller;


import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.dto.CandidateProfileDTO;
import com.training.admissions.entity.Candidate;
import com.training.admissions.exception.CandidateRegistrationException;
import com.training.admissions.service.CandidateProfileService;
import com.training.admissions.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static com.training.admissions.controller.ControllerUtils.getValidationErrors;

@Slf4j
@Controller
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateProfileService candidateProfileService;

    public CandidateController(CandidateService candidateService, CandidateProfileService candidateProfileService) {
        this.candidateService = candidateService;
        this.candidateProfileService = candidateProfileService;
    }

    @PostMapping("/api/candidate/registration")
    public String createCandidate(@Valid CandidateDTO candidateDTO,
                                  CandidateProfileDTO candidateProfileDTO,
                                  BindingResult bindingResult,
                                  Model model
    ) {
//        if (bindingResult.hasErrors()) {
//          throw new CandidateRegistrationException("x",bindingResult.getAllErrors());
//        } else {
            Candidate candidate = candidateService.createCandidate(candidateDTO);
            candidateProfileService.createCandidateProfile(candidateProfileDTO, candidate.getId());
            log.info("new user " + candidateDTO.getUsername() + " created!");
//        }
        return "redirect:/auth/login";
    }







    @DeleteMapping("/api/candidate/{id}")
    public void deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
    }


    @GetMapping("/api/candidate/profile")
    public String getCandidateProfile(@AuthenticationPrincipal User currentUser
            , Model model) {
        model.addAttribute("candidate", candidateService.getByUsername(currentUser.getUsername()));
        return "/candidate/candidate_profile";
    }

    @GetMapping("/api/candidate/edit/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Candidate candidate = candidateService.getById(id);
        model.addAttribute("candidate", candidate);
        return "/candidate/candidate_profile_edit";

    }






    @PostMapping("/api/candidate/update")
    public String updateCandidate(CandidateProfileDTO candidateProfileDTO
    ) {
        candidateProfileService.updateCandidateProfile(candidateProfileDTO);
        return "redirect:/api/candidate/profile";
    }



}


