package com.training.admissions.repository;

import com.training.admissions.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {


    Optional<Candidate> findByUsername(String username);
}
