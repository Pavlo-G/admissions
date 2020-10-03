package com.training.admissions.controller;


import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.model.Candidate;
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

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
    }


//    Principal principal = request.getUserPrincipal();
//    Candidate candidate =candidateService.findByUsername(principal.getName());
//
//        model.addAttribute("admin", candidate.getRole().equals(Role.ADMIN));
//


    @PostMapping("/registration")
    public String createCandidate(CandidateDTO userDTO, Model model) {
        try {
            candidateService.createCandidate(userDTO);
        } catch (CandidateAlreadyExistsException e) {
            model.addAttribute("errorMessage", "User exists!");
            return "registration";
        }

        log.info("new user " + userDTO.getUsername() + " created!");
        return "redirect:/auth/login";
    }
}


