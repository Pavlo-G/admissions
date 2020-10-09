package com.training.admissions.controller;


import com.training.admissions.dto.AdmissionRequestDTO;
import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.service.AdmissionRequestService;
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


@Slf4j
@Controller
public class AdmissionRequestController {

    private final AdmissionRequestService admissionRequestService;


    public AdmissionRequestController(AdmissionRequestService admissionRequestService) {
        this.admissionRequestService = admissionRequestService;

    }


    @GetMapping("/candidate/submit_request_form")
    public String getRequestForm(FacultyDTO facultyDTO,
                                 @AuthenticationPrincipal User currentUser, Model model) {

        if (facultyDTO.isAdmissionOpen()) {
            AdmissionRequestDTO admissionRequestDTO = admissionRequestService.getAdmissionRequestDTO(facultyDTO, currentUser);
            model.addAttribute("faculty", admissionRequestDTO.getFaculty());
            model.addAttribute("candidate", admissionRequestDTO.getCandidate());

            return "/candidate/request_form";
        }
        return "/candidate/candidate_requests";
    }


    @PostMapping("/candidate/submit_request")
    public String createRequestFromCandidate(AdmissionRequestDTO admissionRequestDTO) {
        admissionRequestService.saveAdmissionRequest(admissionRequestDTO);
        return "redirect:/candidate/candidate_requests";
    }


    @GetMapping("/candidate/candidate_requests")
    public String getAllUserRequests(@PageableDefault(sort = {"id"},
            direction = Sort.Direction.ASC, size = 5) Pageable pageable,
                                     @AuthenticationPrincipal User currentUser
            , Model model) {

        Page<AdmissionRequest> page = admissionRequestService.getAdmissionRequestsForUserWithUsername(currentUser.getUsername(), pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/candidate/candidate_requests");
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("requests_list", page);
        return "/candidate/candidate_requests";
    }


    @PostMapping("/candidate/delete_request/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long id) {
        admissionRequestService.deleteRequest(id);
        return "redirect:/candidate/candidate_requests";
    }


    @GetMapping("/admin/requests_of_faculty/{id}")
    public String getRequestsForFacultyById(@PageableDefault(sort = {"admissionRequestStatus"}, direction = Sort.Direction.ASC, size = 5) Pageable pageable,
                                            @PathVariable(name = "id") Long id, Model model) {
        Page<AdmissionRequest> page = admissionRequestService.getAdmissionRequestsForFacultyWithId(id, pageable);

        model.addAttribute("page", page);
        model.addAttribute("url", "/admin/requests_of_faculty/" + id);

        return "/admin/requests_of_faculty";
    }


    @GetMapping("/admin/requests_of_faculty/request/{id}")
    public String getRequestById(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("request", admissionRequestService.getById(id));
        return "/admin/request";
    }


    @PostMapping("/admin/request_update")
    public String requestApprove(AdmissionRequestDTO admissionRequestDTO) {
        admissionRequestService.updateStatusOfRequest(admissionRequestDTO);
        return "redirect:/admin/requests_of_faculty/" + admissionRequestDTO.getFacultyId();
    }




}
