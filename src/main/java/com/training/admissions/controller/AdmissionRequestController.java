package com.training.admissions.controller;


import com.training.admissions.dto.AdmissionRequestDTO;
import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.Faculty;
import com.training.admissions.service.AdmissionRequestService;
import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
        Faculty faculty =facultyService.getById(facultyId);
        if(faculty.isAdmissionOpen()) {
            model.addAttribute("candidate", candidateService.getByUsername(currentUser.getUsername()));
            model.addAttribute("faculty", faculty);
            return "/candidate/request_form";
        }
        return "redirect:/candidate/candidate_requests";
    }


    @PostMapping("/candidate/submit_request")
    public String createRequestFromCandidate(AdmissionRequestDTO admissionRequestDTO, Model model) {

            admissionRequestService.saveAdmissionRequest(admissionRequestDTO);
        return "redirect:/candidate/candidate_requests";
    }




    @GetMapping("/candidate/candidate_requests")
    public String getAllUserRequests(@PageableDefault(sort = {"id"},
            direction = Sort.Direction.ASC, size = 5) Pageable pageable,
            @AuthenticationPrincipal User currentUser
            , Model model) {

        Page<AdmissionRequest> page =admissionRequestService.getAdmissionRequestsForUserWittUsername(currentUser.getUsername(),pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/candidate/candidate_requests");
        model.addAttribute("username",currentUser.getUsername());
        model.addAttribute("requests_list",page);
        return "/candidate/candidate_requests";
    }








    @PostMapping("/candidate/delete_request/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long id) {
        log.info("inside delete method");
        admissionRequestService.deleteRequest(id);
        return "redirect:/candidate/candidate_requests";
    }


}
