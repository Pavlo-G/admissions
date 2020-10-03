package com.training.admissions.service;


import com.training.admissions.dto.AdmissionRequestDTO;
import com.training.admissions.exception.RequestNotFoundException;
import com.training.admissions.model.AdmissionRequest;
import com.training.admissions.model.AdmissionRequestStatus;
import com.training.admissions.model.Candidate;
import com.training.admissions.model.Faculty;
import com.training.admissions.repository.AdmissionRequestRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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

    //    public AdmissionRequest getAdmissionRequestByUserNameAndFaculty(Long userId, Long facultyId) {
//        return admissionRequestRepository
//                .findAdmissionRequestByFacultyIdAndUserId(userId, facultyId)
//                .orElseThrow();
//
//    }
    public List<AdmissionRequest> getAdmissionRequestsForFacultyWithId(Long id) {

        return admissionRequestRepository
                .findAllByFaculty_Id(id);

    }

    public List<AdmissionRequest> getAdmissionRequestsForUserWithId(Long id) {

        return admissionRequestRepository
                .findAllByCandidate_Id(id);

    }

    public boolean saveAdmissionRequest(AdmissionRequestDTO arDTO) {
        Candidate candidate = candidateService.getById(arDTO.getUserId());
        Faculty faculty = facultyService.getById(arDTO.getFacultyId());

        Optional<AdmissionRequest> admissionRequest = admissionRequestRepository
                .findByCandidateAndFaculty(candidate, faculty);

        if (admissionRequest.isEmpty()) {
            admissionRequestRepository.save(AdmissionRequest.builder()
                    .status(AdmissionRequestStatus.NEW)
                    .candidate(candidate)
                    .faculty(faculty)
                    .build());
            return true;
        }
        return false;
    }

    public void deleteRequest(Long id) {
        admissionRequestRepository.deleteById(id);
    }


    public AdmissionRequest getById(Long id) {
       return admissionRequestRepository.findById(id)
               .orElseThrow(()-> new RequestNotFoundException("Request by id= "+id+"not found"));
    }
}
