package com.training.admissions.repository;

import com.training.admissions.entity.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Page<Faculty> findAll(Pageable page);

    Optional<Faculty> findByName(String name);
}
