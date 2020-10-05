package com.training.admissions.controller;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.Candidate;
import com.training.admissions.service.AdmissionRequestService;
import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import com.training.admissions.service.StatementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class AdminWorkspaceController {

    private final FacultyService facultyService;
    private final CandidateService candidateService;
    private final AdmissionRequestService admissionRequestService;
    private final StatementService statementService;

    public AdminWorkspaceController(FacultyService facultyService,
                                    CandidateService candidateService,
                                    AdmissionRequestService admissionRequestService, StatementService statementService) {
        this.facultyService = facultyService;
        this.candidateService = candidateService;
        this.admissionRequestService = admissionRequestService;
        this.statementService = statementService;
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
    public String getAllCandidates(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 5) Pageable pageable,
            Model model) {
        Page<Candidate> page = candidateService.getAllCandidates(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/admin/candidate");

        return "/admin/candidates";
    }

    @GetMapping("/admin/candidate/edit/{id}")
    public String getById(@PathVariable Long id, Model model) {

        model.addAttribute("candidate", candidateService.getById(id));
        return "/admin/candidates-edit";

    }
    @PostMapping("/admin/candidate/edit/{id}")
    public String updateCandidateWithId(CandidateDTO candidateDTO) {
       candidateService.updateCandidate(candidateDTO);
        return "redirect:/admin/candidate";

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


    @GetMapping("/admin/workspace/statement")
    public String getStatement(Model model) {

        List<List<AdmissionRequest>> statementList = statementService.getStatement();

        model.addAttribute("statementList", statementList);
        return "/admin/statement";
    }


    @GetMapping("/admin/faculty/add")
    public String createNewFacultyForm(Model model) {

        return "/admin/create-faculty";
    }


    @PostMapping("/admin/faculty/add")
    public String createNewFaculty(FacultyDTO facultyDTO) {
        facultyService.createFaculty(facultyDTO);

        return "redirect:/admin/workspace";
    }


    @GetMapping("/admin/faculty/edit/{id}")
    public String editFacultyWithId(@PathVariable Long id, Model model) {
        model.addAttribute("faculty", facultyService.getById(id));
        return "/admin/edit-faculty";

    }

    @PostMapping("/admin/faculty/edit/{id}")
    public String updateFacultyWithId(FacultyDTO facultyDTO) {
        facultyService.updateFaculty(facultyDTO);
        return "redirect:/admin/workspace";

    }

    @PostMapping("/admin/faculties/delete/{id}")
    public String deleteFacultyById(@PathVariable(name = "id") Long id) {
        facultyService.deleteById(id);
        return "redirect:/admin/workspace";
    }

}
