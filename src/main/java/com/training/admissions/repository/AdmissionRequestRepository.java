package com.training.admissions.repository;

import com.training.admissions.model.AdmissionRequest;
import com.training.admissions.model.Candidate;
import com.training.admissions.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRequestRepository extends JpaRepository<AdmissionRequest, Long> {
    List<AdmissionRequest> findAllByCandidate_Id(Long id);

    List<AdmissionRequest> findAllByFaculty_Id(Long id);

    Optional<AdmissionRequest> findByCandidateAndFaculty(Candidate candidate, Faculty faculty);
}
