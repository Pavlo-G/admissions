package com.training.admissions.dto;


import com.training.admissions.model.Candidate;
import com.training.admissions.model.Faculty;
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

}
