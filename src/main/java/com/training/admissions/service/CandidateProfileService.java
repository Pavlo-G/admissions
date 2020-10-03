package com.training.admissions.service;

import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.exception.FacultyNotFoundException;
import com.training.admissions.model.CandidateProfile;
import com.training.admissions.model.Faculty;
import com.training.admissions.repository.CandidateProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CandidateProfileService {


    private final CandidateProfileRepository candidateProfileRepository;

    public CandidateProfileService(CandidateProfileRepository candidateProfileRepository) {
        this.candidateProfileRepository = candidateProfileRepository;
    }


    public CandidateProfile getByCandidate_Id(Long id) {
        log.info("Get candidate profile by id: " + id);
        return candidateProfileRepository.findById(id)
                .orElseThrow(()-> new CandidateNotFoundException("Candidate Profile not found!"));
    }




}
