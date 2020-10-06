package com.training.admissions.service;


import com.training.admissions.dto.AdmissionRequestDTO;
import com.training.admissions.exception.RequestAlreadyExistsException;
import com.training.admissions.exception.RequestNotFoundException;
import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import com.training.admissions.repository.AdmissionRequestRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdmissionRequestService {
    private final AdmissionRequestRepository admissionRequestRepository;
    private CandidateService candidateService;
    private FacultyService facultyService;

    public AdmissionRequestService(AdmissionRequestRepository admissionRequestRepository,
                                   CandidateService candidateService, FacultyService facultyService) {
        this.admissionRequestRepository = admissionRequestRepository;
        this.candidateService = candidateService;
        this.facultyService = facultyService;
    }

    @Transactional
    public AdmissionRequest approveRequest(Long id) {
        AdmissionRequest admissionRequest =
                admissionRequestRepository.findById(id).orElseThrow();
        admissionRequest.setStatus(AdmissionRequestStatus.APPROVED);
        admissionRequestRepository.save(admissionRequest);
        return admissionRequest;
    }


    @Transactional
    public AdmissionRequest rejectRequest(Long id) {
        AdmissionRequest admissionRequest =
                admissionRequestRepository.findById(id).orElseThrow();
        admissionRequest.setStatus(AdmissionRequestStatus.REJECTED);
        admissionRequestRepository.save(admissionRequest);
        return admissionRequest;
    }

    public List<AdmissionRequest> getAdmissionRequestsForFacultyWithId(Long id) {
        return admissionRequestRepository
                .findAllByFaculty_Id(id);
    }

    public List<AdmissionRequest> getAdmissionRequestsForUserWithId(Long id) {
        return admissionRequestRepository
                .findAllByCandidate_Id(id);
    }

    public AdmissionRequest saveAdmissionRequest(AdmissionRequestDTO admissionRequestDTO){
        Candidate candidate = candidateService.getById(admissionRequestDTO.getCandidateId());
        Faculty faculty = facultyService.getById(admissionRequestDTO.getFacultyId());

        if (admissionRequestRepository
                .findByCandidateAndFaculty(candidate, faculty).isEmpty()) {

            return admissionRequestRepository.save(
                    AdmissionRequest.builder()
                            .status(AdmissionRequestStatus.NEW)
                            .candidate(candidate)
                            .faculty(faculty)
                            .requiredSubject1Grade(admissionRequestDTO.getRequiredSubject1Grade())
                            .requiredSubject2Grade(admissionRequestDTO.getRequiredSubject2Grade())
                            .requiredSubject3Grade(admissionRequestDTO.getRequiredSubject3Grade())
                            .build());
        }
        throw new RequestAlreadyExistsException("Request Already Exists!");
    }

    public void deleteRequest(Long id) {
        admissionRequestRepository.deleteById(id);
    }


    public AdmissionRequest getById(Long id) {
        return admissionRequestRepository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request by id= " + id + "not found"));
    }


}
