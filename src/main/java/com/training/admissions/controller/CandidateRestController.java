package com.training.admissions.controller;


import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.service.CandidateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/candidate")
public class CandidateRestController {

    private final CandidateService candidateService;

    public CandidateRestController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping
    public List<Candidate> getAll() {

        return candidateService.getAllCandidates();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('candidates:read')")
    public Candidate getById(@PathVariable Long id) throws CandidateNotFoundException {

        return candidateService.getById(id);

    }


    @PostMapping
    public Candidate create(@RequestBody CandidateDTO candidate) throws CandidateAlreadyExistsException {
        return candidateService.createCandidate(candidate);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('candidates:write')")
    public void deleteById(Long id) {
        candidateService.deleteById(id);
    }
}