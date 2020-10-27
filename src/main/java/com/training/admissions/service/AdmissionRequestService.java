package com.training.admissions.service;


import com.training.admissions.dto.AdmissionRequestDTO;
import com.training.admissions.dto.FacultyDTO;
import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import com.training.admissions.exception.RequestAlreadyExistsException;
import com.training.admissions.exception.RequestNotFoundException;
import com.training.admissions.repository.AdmissionRequestRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


@Service
public class AdmissionRequestService {
    private final AdmissionRequestRepository admissionRequestRepository;
    private final CandidateService candidateService;
    private final  FacultyService facultyService;

    public AdmissionRequestService(AdmissionRequestRepository admissionRequestRepository,
                                   CandidateService candidateService, FacultyService facultyService) {
        this.admissionRequestRepository = admissionRequestRepository;
        this.candidateService = candidateService;
        this.facultyService = facultyService;
    }


    public Integer updateStatusOfRequest(AdmissionRequestDTO admissionRequestDTO) {
        return admissionRequestRepository.updateRequest(admissionRequestDTO.getId(), admissionRequestDTO.getAdmissionRequestStatus());
    }


    public Page<AdmissionRequest> getAdmissionRequestsForFacultyWithId(Long id, Pageable pageable) {
        return admissionRequestRepository
                .findAllByFaculty_Id(id, pageable);
    }

    public Page<AdmissionRequest> getAdmissionRequestsForUserWithUsername(String username, Pageable pageable) {
        return admissionRequestRepository
                .findAllByCandidate_Username(username, pageable);
    }


    public AdmissionRequest saveAdmissionRequest(AdmissionRequestDTO admissionRequestDTO) {
        try {
            Candidate candidate = Candidate.builder().id(admissionRequestDTO.getCandidateId()).build();
            Faculty faculty = Faculty.builder().id(admissionRequestDTO.getFacultyId()).build();

            return admissionRequestRepository.save(
                    AdmissionRequest.builder()
                            .id(admissionRequestDTO.getId())
                            .admissionRequestStatus(AdmissionRequestStatus.NEW)
                            .candidate(candidate)
                            .faculty(faculty)
                            .requiredSubject1Grade(admissionRequestDTO.getRequiredSubject1Grade())
                            .requiredSubject2Grade(admissionRequestDTO.getRequiredSubject2Grade())
                            .requiredSubject3Grade(admissionRequestDTO.getRequiredSubject3Grade())
                            .build());
        } catch (DataIntegrityViolationException ex) {
            throw new RequestAlreadyExistsException("Request Already Exists!");
        }

    }


    public void deleteRequest(Long id) {
        admissionRequestRepository.deleteById(id);
    }


    public AdmissionRequest getById(Long id) {
        return admissionRequestRepository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request by id= " + id + "not found"));
    }


    public AdmissionRequestDTO getAdmissionRequestDTO(FacultyDTO facultyDTO, User currentUser) {
        Candidate candidate = candidateService.getByUsername(currentUser.getUsername());
        Faculty faculty= facultyService.getById(facultyDTO.getId());

        return AdmissionRequestDTO.builder().candidate(candidate).faculty(faculty).build();

    }
}
