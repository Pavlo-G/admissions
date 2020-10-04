package com.training.admissions.service;

import com.training.admissions.dto.CandidateProfileDTO;
import com.training.admissions.exception.CandidateAlreadyExistsException;
import com.training.admissions.exception.CandidateNotFoundException;
import com.training.admissions.model.CandidateProfile;
import com.training.admissions.repository.CandidateProfileRepository;
import com.training.admissions.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CandidateProfileService {


    private final CandidateProfileRepository candidateProfileRepository;
    private final CandidateRepository candidateRepository;

    public CandidateProfileService(CandidateProfileRepository candidateProfileRepository, CandidateRepository candidateRepository) {
        this.candidateProfileRepository = candidateProfileRepository;
        this.candidateRepository = candidateRepository;
    }


    public CandidateProfile getByCandidate_Id(Long id) {
        log.info("Get candidate profile by id: " + id);
        return candidateProfileRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate Profile not found!"));
    }


    public CandidateProfile updateCandidateProfile(CandidateProfileDTO candidateProfileDTO) {

        CandidateProfile candidateProfile = candidateProfileRepository.findById(candidateProfileDTO.getId())
                .orElseThrow(() -> new CandidateNotFoundException("Candidate details not found!"));
        candidateProfile.setFirstName(candidateProfileDTO.getFirstName());
        candidateProfile.setLastName(candidateProfileDTO.getLastName());
        candidateProfile.setAddress(candidateProfileDTO.getAddress());
        candidateProfile.setCity(candidateProfileDTO.getCity());
        candidateProfile.setRegion(candidateProfileDTO.getRegion());
        candidateProfile.setSchool(candidateProfileDTO.getSchool());
        candidateProfile.setEmail(candidateProfileDTO.getEmail());
        candidateProfile.setPhoneNumber(candidateProfileDTO.getPhoneNumber());


        return candidateProfileRepository.save(candidateProfile);


    }


    public CandidateProfile createCandidateProfile(CandidateProfileDTO candidateProfileDTO,Long id) {
        if (candidateProfileRepository.findByCandidate_Id(id).isEmpty()) {

            CandidateProfile candidateProfile = candidateProfileRepository.save(
                    CandidateProfile.builder()
                            .firstName(candidateProfileDTO.getFirstName())
                            .lastName(candidateProfileDTO.getLastName())
                            .email(candidateProfileDTO.getEmail())
                            .address(candidateProfileDTO.getAddress())
                            .city(candidateProfileDTO.getCity())
                            .region(candidateProfileDTO.getRegion())
                            .school(candidateProfileDTO.getSchool())
                            .phoneNumber(candidateProfileDTO.getPhoneNumber())
                            .candidate(candidateRepository.findById(id)
                                    .orElseThrow(()->new CandidateNotFoundException("Candidate Not Found!"))

                            )
                            .build());
            log.info("CandidateDetails  created with id: " + candidateProfile.getId());
            return candidateProfile;

        }
        throw new CandidateAlreadyExistsException("Candidate Details already exists!");

    }
}

