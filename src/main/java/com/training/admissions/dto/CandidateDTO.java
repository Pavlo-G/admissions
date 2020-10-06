package com.training.admissions.dto;


import com.training.admissions.entity.CandidateStatus;
import com.training.admissions.entity.Role;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidateDTO {

private Long id;

    @NotBlank(message = "Name is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    private String password;
    private Role role;
    private CandidateStatus candidateStatus;


}
