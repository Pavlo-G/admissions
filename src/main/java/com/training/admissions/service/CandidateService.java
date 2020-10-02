package com.training.admissions.service;

import com.training.admissions.dto.CandidateDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.Candidate;
import com.training.admissions.model.Role;
import com.training.admissions.model.Status;
import com.training.admissions.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class CandidateService {


    private final CandidateRepository candidateRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public CandidateService(CandidateRepository candidateRepository, PasswordEncoder bCryptPasswordEncoder) {

        this.candidateRepository = candidateRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public List<Candidate> getAllCandidates() {
        log.info("Get All Candidates");
        return candidateRepository.findAll();
    }

    public Candidate getById(Long id) throws CandidateNotFoundException {
        log.info("Get candidate by id: " + id);
        return candidateRepository.findById(id)
                .orElseThrow(
                        () -> new CandidateNotFoundException("Candidate with " + id + "not found"));
    }

    @Transactional
    public Candidate createCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException {
        if (candidateRepository.findByUsername(candidateDTO.getUsername()).isEmpty()) {

            Candidate createdCandidate = candidateRepository.save(Candidate.builder()
                    .username(candidateDTO.getUsername())
                    .password(bCryptPasswordEncoder.encode(candidateDTO.getPassword()))
                    .email(candidateDTO.getEmail())
                    .role(Role.USER)
                    .status(Status.ACTIVE)
                    .build());
            log.info("User created: " + createdCandidate.getUsername());
            return createdCandidate;
        }
        throw new CandidateAlreadyExistsException("Candidate already exists");
    }


    public void deleteById(Long id) {
        log.info("Faculty removed id: " + id);
        candidateRepository.deleteById(id);

    }
}