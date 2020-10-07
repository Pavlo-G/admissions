package com.training.admissions.repository;

import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRequestRepository extends JpaRepository<AdmissionRequest, Long> {

    Page<AdmissionRequest> findAllByCandidate_Username(String username, Pageable pageable);

    Page<AdmissionRequest> findAllByFaculty_Id(Long id,Pageable pageable);

    Optional<AdmissionRequest> findByCandidateAndFaculty(Candidate candidate, Faculty faculty);
}
