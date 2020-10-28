package com.training.admissions.dto;


import com.training.admissions.entity.AdmissionRequestStatus;
import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Lob;
import javax.validation.constraints.*;

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

    @NotNull(message = "can not be empty")
    @Range(min = 1, max = 12, message = "grade should be from 1 to 12")
    private Integer requiredSubject1Grade;

    @NotNull(message = "can not be empty")
    @Range(min = 1, max = 12, message = "grade should be from 1 to 12")
    private Integer requiredSubject2Grade;

    @NotNull(message = "can not be empty")
    @Range(min = 1, max = 12, message = "grade should be from 1 to 12")
    private Integer requiredSubject3Grade;





    private AdmissionRequestStatus admissionRequestStatus;

}
