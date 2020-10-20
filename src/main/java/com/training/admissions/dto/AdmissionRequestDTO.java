package com.training.admissions.dto;


import com.training.admissions.entity.AdmissionRequestStatus;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdmissionRequestDTO {
    private Long id;
    private Long candidateId;
    private Long facultyId;
    private Candidate candidate;
    private Faculty faculty;

    @NotBlank(message ="Grade can not be empty" )
    @Min(0)
    @Max(12)
    private int requiredSubject1Grade;
    @NotBlank(message ="Grade can not be empty" )
    @Min(0)
    @Max(12)
    private int requiredSubject2Grade;
    @NotBlank(message ="Grade can not be empty" )
    @Min(0)
    @Max(12)
    private int requiredSubject3Grade;
    private AdmissionRequestStatus admissionRequestStatus;

}
