package com.training.admissions.service;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.model.Role;
import com.training.admissions.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class CandidateService {


    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getById(Long id) throws CandidateNotFoundException {
        return candidateRepository.findById(id)
                .orElseThrow(
                        () -> new CandidateNotFoundException("Candidate with " + id + "not found"));
    }


    public Candidate createCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException {
        if (candidateRepository.findByUsername(candidateDTO.getUsername()).isEmpty()) {

            Candidate createdCandidate = candidateRepository.save(Candidate.builder()
                    .username(candidateDTO.getUsername())
                    .password(candidateDTO.getPassword())
                    .email(candidateDTO.getEmail())
                    .role(Role.USER)
                    .build());
            log.info("User created: " + createdCandidate.getUsername());
            return createdCandidate;
        }
        throw new CandidateAlreadyExistsException("Candidate already exists");

    }


    public void deleteById(Long id) {
        candidateRepository.deleteById(id);

    }
}
