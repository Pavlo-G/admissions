package com.training.admissions.repository;

import com.training.admissions.entity.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement,Long> {
}
