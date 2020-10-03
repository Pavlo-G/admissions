package com.training.admissions.controller;


import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.service.CandidateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping
    public String getAllCandidates(Model model) {
        model.addAttribute("all_candidates", candidateService.getAllCandidates());
        return "/admin/candidates";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id,Model model) throws CandidateNotFoundException {

        model.addAttribute("candidate",candidateService.getById(id));
        return "/admin/candidates";

    }


    @PostMapping
    public Candidate create(@RequestBody CandidateDTO candidate) throws CandidateAlreadyExistsException {
        return candidateService.createCandidate(candidate);
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

}