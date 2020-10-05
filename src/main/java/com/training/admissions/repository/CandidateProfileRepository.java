package com.training.admissions.repository;

import com.training.admissions.entity.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile,Long> {

Optional<CandidateProfile> findByCandidate_Id(Long id);

}
