package com.training.admissions.controller;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.service.CandidateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.service.CandidateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/faculty")
public class FacultyController {


        private final FacultyService facultyService;



        @GetMapping
        public List<Faculty> getAll() {

            return candidateService.getAllCandidates();
        }

        @GetMapping("/{id}")
        @PreAuthorize("hasAuthority('candidates:read')")
        public Candidate getById(@PathVariable Long id) throws CandidateNotFoundException {

            return candidateService.getById(id);

        }


        @PostMapping
        @PreAuthorize("hasAuthority('candidates:write')")
        public Candidate create(@RequestBody CandidateDTO candidate) throws CandidateAlreadyExistsException {
            return candidateService.createCandidate(candidate);
        }


        @DeleteMapping("/{id}")
        @PreAuthorize("hasAuthority('candidates:write')")
        public void deleteById(Long id) {
            candidateService.deleteById(id);
        }
    }
}
