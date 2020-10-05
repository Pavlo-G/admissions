package com.training.admissions.controller;


import com.training.admissions.service.CandidateService;
import com.training.admissions.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller

public class FacultyController {
    private final CandidateService candidateService;
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService, CandidateService candidateService) {
        this.facultyService = facultyService;
        this.candidateService=candidateService;
    }


    @GetMapping("/faculties2")
    public String getAllFaculties(Model model) {
        model.addAttribute("all_faculties", facultyService.getAllFaculties());
        return "/faculties2";
    }

//    @PostMapping()
//    public String getAllFacultiesSorted(
//            @RequestParam(name = "filter_option") Integer numOption, Model model) {
//        model.addAttribute("all_faculties", facultyService.getAllFacultiesSorted(numOption));
//
//        return "/faculties";
//    }

}
