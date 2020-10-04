package com.training.admissions.dto;


import lombok.*;

import javax.persistence.Column;

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


}
