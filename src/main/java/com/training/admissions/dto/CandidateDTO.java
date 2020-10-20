package com.training.admissions.dto;


import com.training.admissions.entity.CandidateStatus;
import com.training.admissions.entity.Role;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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
    @Length(min = 3, message = "username is too short min 3")
    @Length( max = 20, message = "username is too long max 15")
    private String username;
    @NotBlank(message = "password is mandatory")
    @Length(min = 3, message = "password is too short min 3")
    @Length( max = 20, message = "password is too long max 15")
    private String password;
    private Role role;
    private CandidateStatus candidateStatus;


}
