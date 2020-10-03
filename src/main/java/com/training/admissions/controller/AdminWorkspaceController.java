package com.training.admissions.controller;

import com.training.admissions.service.AdmissionRequestService;
import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
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


    @GetMapping("/workspace")
    public String getAdminWorkspace(Model model) {


        model.addAttribute("faculties_list", facultyService.getAllFacultiesWithRequests());

        return "/admin/admin_workspace";
    }


    @GetMapping("/requests_of_faculty/{id}")
    public String getRequestsForFacultyById(@PathVariable(name = "id") Long id, Model model) {


        model.addAttribute("requests_list", admissionRequestService.getAdmissionRequestsForFacultyWithId(id));
        model.addAttribute("faculty_name", facultyService.getById(id).getName());

        return "/admin/requests_of_faculty";
    }



    @GetMapping("/requests_of_faculty/request/{id}")
    public String getRequestById(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("request", admissionRequestService.getById(id));
        return "/admin/request";
    }

}
