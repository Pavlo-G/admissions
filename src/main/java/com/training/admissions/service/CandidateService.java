package com.training.admissions.service;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.Faculty;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.CandidateStatus;
import com.training.admissions.entity.Role;
import com.training.admissions.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Slf4j
@Service
public class CandidateService {


    private final CandidateRepository candidateRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public CandidateService(CandidateRepository candidateRepository, PasswordEncoder bCryptPasswordEncoder) {

        this.candidateRepository = candidateRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public Page<Candidate> getAllCandidates(Pageable pageable) {
        return candidateRepository.findAll(pageable);
    }

    public Candidate getById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(
                        () -> new CandidateNotFoundException("Candidate with " + id + "not found"));
    }

    @Transactional
    public Candidate createCandidate(CandidateDTO candidateDTO) {
        if (candidateRepository.findByUsername(candidateDTO.getUsername())
                .isEmpty()) {
            return candidateRepository.save(Candidate.builder()
                    .username(candidateDTO.getUsername())
                    .password(bCryptPasswordEncoder.encode(candidateDTO.getPassword()))
                    .role(Role.USER)
                    .candidateStatus(CandidateStatus.ACTIVE)
                    .build());
        }
        throw new CandidateAlreadyExistsException("Candidate already exists!");
    }


    public void deleteById(Long id) {
        log.info("Candidate removed id: " + id);
        candidateRepository.deleteById(id);

    }

    public Candidate findByUsername(String name) {
        log.info("Get candidate by name: " + name);
        return candidateRepository.findByUsername(name)
                .orElseThrow(
                        () -> new CandidateNotFoundException("Candidate with name: " + name + "not found"));
    }


    public Candidate updateCandidate(CandidateDTO candidateDTO) {

        Candidate candidate = candidateRepository.findById(candidateDTO.getId()).orElseThrow();
        candidate.setRole(candidateDTO.getRole());
        candidate.setCandidateStatus(candidateDTO.getCandidateStatus());
        return candidateRepository.save(candidate);
    }
}

