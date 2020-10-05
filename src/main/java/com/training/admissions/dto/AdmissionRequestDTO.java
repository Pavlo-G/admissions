package com.training.admissions.dto;


import com.training.admissions.entity.Candidate;
import com.training.admissions.entity.Faculty;
import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdmissionRequestDTO {

    private Long candidateId;
    private Long facultyId;
    private int requiredSubject1Grade;
    private int requiredSubject2Grade;
    private int requiredSubject3Grade;

}
