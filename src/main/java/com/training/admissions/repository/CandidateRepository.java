package com.training.admissions.repository;

import com.training.admissions.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Page<Candidate> findAll(Pageable pageable);

    Optional<Candidate> findByUsername(String username);
}
