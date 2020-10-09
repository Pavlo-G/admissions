package com.training.admissions.repository;

import com.training.admissions.entity.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE CandidateProfile  cp SET " +
            "cp.firstName = :firstName," +
            "cp.lastName=:lastName," +
            "cp.email=:email," +
            "cp.address=:address," +
            "cp.city=:city," +
            "cp.region=:region," +
            "cp.school=:school," +
            "cp.phoneNumber=:phoneNumber" +
            " WHERE cp.id = :id")
    int setProfileUpdate(@Param("id") Long id,
                         @Param("firstName") String firstName,
                         @Param("lastName") String lastName,
                         @Param("email") String email,
                         @Param("address") String address,
                         @Param("city") String city,
                         @Param("region") String region,
                         @Param("school") String school,
                         @Param("phoneNumber") String phoneNumber);
}
