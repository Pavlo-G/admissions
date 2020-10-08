package com.training.admissions.dto;


import com.training.admissions.controller.CandidateController;
import com.training.admissions.entity.Candidate;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidateProfileDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String city;

    private String region;

    private String school;

    private String phoneNumber;

    private  Long candidateId;

}
