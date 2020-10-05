package com.training.admissions.repository;

import com.training.admissions.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    Optional<Faculty> findByName(String name);
}
