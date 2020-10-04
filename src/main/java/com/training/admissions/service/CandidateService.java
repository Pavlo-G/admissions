package com.training.admissions.service;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.model.CandidateStatus;
import com.training.admissions.model.Role;
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

        log.info("Get All Candidates");

        return candidateRepository.findAll(pageable);
    }

    public Candidate getById(Long id) throws CandidateNotFoundException {
        log.info("Get candidate by id: " + id);
        return candidateRepository.findById(id)
                .orElseThrow(
                        () -> new CandidateNotFoundException("Candidate with " + id + "not found"));
    }

    @Transactional
    public Candidate createCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException {
        if (candidateRepository.findByUsername(candidateDTO.getUsername())
                .isEmpty()) {
            Candidate createdCandidate = candidateRepository.save(Candidate.builder()
                    .username(candidateDTO.getUsername())
                    .password(bCryptPasswordEncoder.encode(candidateDTO.getPassword()))
                    .role(Role.USER)
                    .candidateStatus(CandidateStatus.ACTIVE)
                    .build());
            log.info("User created: " + createdCandidate.getUsername());
            return createdCandidate;
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


}
