package com.training.admissions.repository;

import com.training.admissions.dto.AdmissionRequestDTO;
import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import com.training.admissions.entity.Candidate;
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

public interface AdmissionRequestRepository extends JpaRepository<AdmissionRequest, Long> {

    Page<AdmissionRequest> findAllByCandidate_Username(String username, Pageable pageable);

    Page<AdmissionRequest> findAllByFaculty_Id(Long id, Pageable pageable);

    Optional<AdmissionRequest> findByCandidateAndFaculty(Candidate candidate, Faculty faculty);


    @Transactional
    @Modifying
    @Query("UPDATE AdmissionRequest  ar SET " +
            "ar.admissionRequestStatus = :admissionRequestStatus" +
            " WHERE ar.id = :id")
    int updateRequest(@Param("id") Long id,
                      @Param("admissionRequestStatus") AdmissionRequestStatus admissionRequestStatus);





    @Query("SELECT c,f FROM  Candidate c,Faculty f  WHERE c.username=:username AND f.id=:id")
    AdmissionRequest getCandidateAndFacultyForRequest(@Param("id")Long id,@Param("username") String username);
}




