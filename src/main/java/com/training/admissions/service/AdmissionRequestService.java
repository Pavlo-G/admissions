package com.training.admissions.service;


import com.training.admissions.exception.RequestAlreadyExistsException;
import com.training.admissions.exception.RequestNotFoundException;
import com.training.admissions.model.AdmissionRequest;
import com.training.admissions.model.AdmissionRequestStatus;
import com.training.admissions.model.Candidate;
import com.training.admissions.model.Faculty;
import com.training.admissions.repository.AdmissionRequestRepository;
import org.springframework.stereotype.Service;

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





    public AdmissionRequest approveRequest(Long id) {
        AdmissionRequest admissionRequest =
                admissionRequestRepository.findById(id).orElseThrow();
        admissionRequest.setStatus(AdmissionRequestStatus.APPROVED);
        admissionRequestRepository.save(admissionRequest);
        return admissionRequest;
    }



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

    public AdmissionRequest saveAdmissionRequest(Long candidateId, Long facultyId) throws RequestAlreadyExistsException {
        Candidate candidate = candidateService.getById(candidateId);
        Faculty faculty = facultyService.getById(facultyId);

        if (admissionRequestRepository
                .findByCandidateAndFaculty(candidate, faculty).isEmpty()) {

            return admissionRequestRepository.save(
                    AdmissionRequest.builder()
                            .status(AdmissionRequestStatus.NEW)
                            .candidate(candidate)
                            .faculty(faculty)
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
