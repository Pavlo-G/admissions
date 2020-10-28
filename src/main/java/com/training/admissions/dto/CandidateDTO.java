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

    @NotBlank(message = "{username.not_empty}")
    @Length( max = 15, message ="{username.too_long} ")
    private String username;
    @NotBlank(message = "{password.not_empty}")
    @Length( max = 15, message = "{password.too_long}")
    private String password;
    private Role role;
    private CandidateStatus candidateStatus;




}
