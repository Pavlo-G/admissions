package com.training.admissions.repository;

import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface AdmissionRequestRepository extends JpaRepository<AdmissionRequest, Long> {

    Page<AdmissionRequest> findAllByCandidate_Username(String username, Pageable pageable);

    Page<AdmissionRequest> findAllByFaculty_Id(Long id, Pageable pageable);


    @Transactional
    @Modifying
    @Query("UPDATE AdmissionRequest  ar SET " +
            "ar.admissionRequestStatus = :admissionRequestStatus" +
            " WHERE ar.id = :id")
    int updateRequest(@Param("id") Long id,
                      @Param("admissionRequestStatus") AdmissionRequestStatus admissionRequestStatus);

}




