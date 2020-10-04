package com.training.admissions.controller;

import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.service.AdmissionRequestService;
import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AdminWorkspaceController {

    private final FacultyService facultyService;
    private final CandidateService candidateService;
    private final AdmissionRequestService admissionRequestService;

    public AdminWorkspaceController(FacultyService facultyService,
                                    CandidateService candidateService,
                                    AdmissionRequestService admissionRequestService) {
        this.facultyService = facultyService;
        this.candidateService = candidateService;
        this.admissionRequestService = admissionRequestService;
    }


    @GetMapping("/admin/workspace")
    public String getAdminWorkspace(Model model) {


        model.addAttribute("faculties_list", facultyService.getAllFacultiesWithRequests());

        return "/admin/admin_workspace";
    }


    @GetMapping("/admin/requests_of_faculty/{id}")
    public String getRequestsForFacultyById(@PathVariable(name = "id") Long id, Model model) {


        model.addAttribute("requests_list", admissionRequestService.getAdmissionRequestsForFacultyWithId(id));
        model.addAttribute("faculty_name", facultyService.getById(id).getName());

        return "/admin/requests_of_faculty";
    }


    @GetMapping("/admin/requests_of_faculty/request/{id}")
    public String getRequestById(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("request", admissionRequestService.getById(id));
        return "/admin/request";
    }


    @GetMapping("/admin/candidate")
    public String getAllCandidates(Model model) {
        model.addAttribute("all_candidates", candidateService.getAllCandidates());
        return "/admin/candidates";
    }

    @GetMapping("/admin/candidate/{id}")
    public String getById(@PathVariable Long id, Model model) throws CandidateNotFoundException {

        model.addAttribute("candidate", candidateService.getById(id));
        return "/admin/candidates";

    }

    @PostMapping("/admin/candidate/delete/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long id) {
        log.info("inside admin/candidate/delete method");
        candidateService.deleteById(id);
        return "redirect:/admin/candidate";
    }




    @PostMapping("/admin/request_approve")
    public String requestApprove(@RequestParam(name = "requestId") Long requestId,
                                 @RequestParam(name = "facultyId") Long facultyId) {
        admissionRequestService.approveRequest(requestId);
        return "redirect:/admin/requests_of_faculty/" + facultyId;
    }

    @PostMapping("/admin/request_reject")
    public String requestReject(@RequestParam(name = "requestId") Long requestId, @RequestParam(name = "facultyId") Long facultyId) {
        admissionRequestService.rejectRequest(requestId);
        return "redirect:/admin/requests_of_faculty/" + facultyId;
    }

}
