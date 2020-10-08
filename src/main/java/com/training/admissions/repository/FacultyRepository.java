package com.training.admissions.repository;

import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {


//    @Modifying
//    @Query("UPDATE Faculty f set f.admissionOpen = false WHERE f.id = :id")
//    int blockAdmissionRequestRegistration(@Param("id") Long id);
//
//    @Modifying
//    @Query("UPDATE Faculty  f set f.admissionOpen = true WHERE f.id = :id")
//    int unblockAdmissionRequestRegistration(@Param("id") Long id);

    Page<Faculty> findAll(Pageable page);

    Optional<Faculty> findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Faculty f set " +
            "f.id = :id," +
            "f.name=:name," +
            "f.description=:description," +
            "f.budgetCapacity=:budgetCapacity," +
            "f.totalCapacity=:totalCapacity," +
            "f.requiredSubject1=:requiredSubject1, " +
            "f.requiredSubject2=:requiredSubject2," +
            "f.requiredSubject3=:requiredSubject3," +
            "f.admissionOpen=:admissionOpen " +
            "WHERE f.id =:id")
    int updateFaculty(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("description") String description,
            @Param("budgetCapacity") int budgetCapacity,
            @Param("totalCapacity") int totalCapacity,
            @Param("requiredSubject1") String requiredSubject1,
            @Param("requiredSubject2") String requiredSubject2,
            @Param("requiredSubject3") String requiredSubject3,
            @Param("admissionOpen") boolean admissionOpen);
}
