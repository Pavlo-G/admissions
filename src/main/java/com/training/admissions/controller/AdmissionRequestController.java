package com.training.admissions.controller;


import com.training.admissions.dto.AdmissionRequestDTO;
import com.training.admissions.model.Candidate;
import com.training.admissions.service.AdmissionRequestService;
import com.training.admissions.service.CandidateService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller

//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

public class AdmissionRequestController {

    private final AdmissionRequestService admissionRequestService;
    private CandidateService candidateService;


    public AdmissionRequestController(AdmissionRequestService admissionRequestService, CandidateService candidateService) {
        this.admissionRequestService = admissionRequestService;
        this.candidateService =candidateService;

    }

    @GetMapping("/candidate/submit_request")
    public String getRequestForm(@RequestParam(name = "faculty_id") Long facultyId,
            @RequestParam(name = "username") String username, Model model) {

        model.addAttribute("userId", candidateService.findByUsername(username).getId());
        model.addAttribute("facultyId", facultyId);
        return "/candidate/request_form";
    }


    @PostMapping("/candidate/submit_request")
    public String addRequestFromCandidate(AdmissionRequestDTO arDTO, Model model) {

        log.info("inside Post AdmReq " + arDTO.getUserId() + " " + arDTO.getFacultyId());
        if (!admissionRequestService.saveAdmissionRequest(arDTO)) {
            model.addAttribute("userId", arDTO.getUserId());
            model.addAttribute("facultyId", arDTO.getFacultyId());
            model.addAttribute("errorMessage", "Request already exists chose other faculty!");
            return "candidate/request_form";
        }
        return "redirect:/candidate/candidate_requests";
    }

    @GetMapping("/candidate/candidate_requests")
    public String getAllUserRequests(@AuthenticationPrincipal User currentUser
            , Model model) {
        log.info("inside Get all requests");

        Candidate candidate = candidateService.findByUsername(currentUser.getUsername());
        model.addAttribute("username",candidate.getUsername());
        model.addAttribute("requests_list",
                admissionRequestService.getAdmissionRequestsForUserWithId (candidate.getId()));
        return "/candidate/candidate_requests";
    }


    @PostMapping("/candidate/delete_request/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long Id) {
        log.info("inside delete method");
        admissionRequestService.deleteRequest(Id);
        return "redirect:/candidate/candidate_requests";
    }


}
