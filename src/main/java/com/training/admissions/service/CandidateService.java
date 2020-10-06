package com.training.admissions.service;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.entity.*;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
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

    public Candidate getByUsername(String name) {
        return candidateRepository.findByUsername(name)
                .orElseThrow(
                        () -> new CandidateNotFoundException("Candidate with name: " + name + "not found"));
    }


    @Transactional
    public Candidate createCandidate(CandidateDTO candidateDTO) {
        candidateRepository.findByUsername(candidateDTO.getUsername())
                .ifPresent(s -> {
                    throw new CandidateAlreadyExistsException("Candidate with username - " + candidateDTO.getUsername() + " - already Exists");
                });

        return candidateRepository.save(Candidate.builder()
                .username(candidateDTO.getUsername())
                .password(bCryptPasswordEncoder.encode(candidateDTO.getPassword()))
                .role(Role.USER)
                .candidateStatus(CandidateStatus.ACTIVE)
                .build());
    }

    @Transactional
    public Candidate updateCandidate(CandidateDTO candidateDTO) {

        Candidate candidate = candidateRepository.findById(candidateDTO.getId())
                .orElseThrow(() -> new CandidateNotFoundException(
                        "Candidate with " + candidateDTO.getId() + "not found"));

        candidate.setRole(candidateDTO.getRole());
        setCandidateRequestsStatus(candidateDTO, candidate);
        candidate.setCandidateStatus(candidateDTO.getCandidateStatus());
        return candidateRepository.save(candidate);
    }

    private void setCandidateRequestsStatus(CandidateDTO candidateDTO, Candidate candidate) {
        if (candidateDTO.getCandidateStatus() == CandidateStatus.BLOCKED) {
            for (AdmissionRequest ar : candidate.getAdmissionRequestList()) {
                ar.setStatus(AdmissionRequestStatus.REJECTED);
            }
        }
        if (candidateDTO.getCandidateStatus() == CandidateStatus.ACTIVE && candidate.getCandidateStatus() == CandidateStatus.BLOCKED) {
            for (AdmissionRequest ar : candidate.getAdmissionRequestList()) {
                ar.setStatus(AdmissionRequestStatus.NEW);
            }
        }
    }


    public void deleteById(Long id) {
        log.info("Candidate removed id: " + id);
    }

}

