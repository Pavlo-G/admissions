package com.training.admissions.repository;

import com.training.admissions.model.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile,Long> {

CandidateProfile findByCandidate_Id(Long id);

}
