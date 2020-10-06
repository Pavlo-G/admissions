package com.training.admissions.service;

import com.training.admissions.entity.*;
import com.training.admissions.repository.StatementRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatementService {

    private final FacultyService facultyService;
    private final StatementRepository statementRepository;


    public StatementService(FacultyService facultyService, StatementRepository statementRepository) {
        this.facultyService = facultyService;

        this.statementRepository = statementRepository;
    }


    public List<AdmissionRequest> getStatementForFacultyWithId(Long id) {
        Faculty faculty = facultyService.getById(id);

        return faculty.getAdmissionRequestList()
                .stream()
                .filter(x -> x.getStatus() == AdmissionRequestStatus.APPROVED)
                .limit(faculty.getTotalCapacity())
                .sorted(
                        Comparator.comparingInt(AdmissionRequest::getSumOfGrades).reversed()
                                .thenComparing(AdmissionRequest::getCreationDateTime))
                .collect(Collectors.toList());

    }

    public void facultyStatementFinalize(Long id, String author) {

        Faculty faculty = facultyService.getById(id);

        Statement statement= Statement.builder()
                .author(author)
                .enrolledCandidates(  getEnrolledCandidateFromRequest(faculty))
                .build();

          statementRepository.save(statement);
    }

    private List<EnrolledCandidate> getEnrolledCandidateFromRequest(Faculty faculty) {

        List<EnrolledCandidate> enrolledCandidates = new ArrayList<>();

        for (AdmissionRequest ar : faculty.getAdmissionRequestList()) {
            enrolledCandidates.add(EnrolledCandidate.builder()
                    .firstName(ar.getCandidate().getCandidateProfile().getFirstName())
                    .lastName(ar.getCandidate().getCandidateProfile().getLastName())
                    .email(ar.getCandidate().getCandidateProfile().getEmail())
                    .phoneNumber(ar.getCandidate().getCandidateProfile().getPhoneNumber())
                    .grade(ar.getSumOfGrades()).build());

        }
        return enrolledCandidates;
    }

    public List<Statement> getAllFinalizedStatements() {
      return   statementRepository.findAll();
    }
}
