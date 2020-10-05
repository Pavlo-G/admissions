package com.training.admissions.dto;


import com.training.admissions.entity.CandidateStatus;
import com.training.admissions.entity.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidateDTO {

private Long id;
    private String username;


    private String password;

    private Role role;

    private CandidateStatus candidateStatus;


}
