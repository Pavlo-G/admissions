package com.training.admissions.controller;


import com.training.admissions.exception.RequestAlreadyExistsException;
import com.training.admissions.model.Candidate;
import com.training.admissions.service.AdmissionRequestService;
import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller

public class AdmissionRequestController {

    private final AdmissionRequestService admissionRequestService;
    private final CandidateService candidateService;
    private final FacultyService facultyService;


    public AdmissionRequestController(AdmissionRequestService admissionRequestService, CandidateService candidateService, FacultyService facultyService) {
        this.admissionRequestService = admissionRequestService;
        this.candidateService = candidateService;

        this.facultyService = facultyService;
    }

    @GetMapping("/candidate/submit_request")
    public String getRequestForm(@RequestParam(name = "faculty_id") Long facultyId,
                                 @AuthenticationPrincipal User currentUser, Model model) {

        model.addAttribute("candidate", candidateService.findByUsername(currentUser.getUsername()));
        model.addAttribute("faculty", facultyService.getById(facultyId));
        return "/candidate/request_form";
    }


    @PostMapping("/candidate/submit_request")
    public String createRequestFromCandidate(@RequestParam(name = "candidate") Long candidateId,
                                             @RequestParam(name = "faculty") Long facultyId, Model model) {

            admissionRequestService.saveAdmissionRequest(candidateId, facultyId);
        return "redirect:/candidate/candidate_requests";
    }

    @GetMapping("/candidate/request_form/error")
    public String showError(Model model) {
        model.addAttribute("errorMessage", "Request Already Exists!");
        return "candidate/request_form";
    }


    @GetMapping("/candidate/candidate_requests")
    public String getAllUserRequests(@AuthenticationPrincipal User currentUser
            , Model model) {
        Candidate candidate = candidateService.findByUsername(currentUser.getUsername());
        log.info("Get all requests for candidate"+candidate.getUsername());
        model.addAttribute("username", candidate.getUsername());
        model.addAttribute("requests_list",
                admissionRequestService.getAdmissionRequestsForUserWithId(candidate.getId()));
        return "/candidate/candidate_requests";
    }


    @PostMapping("/candidate/delete_request/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long id) {
        log.info("inside delete method");
        admissionRequestService.deleteRequest(id);
        return "redirect:/candidate/candidate_requests";
    }


}
