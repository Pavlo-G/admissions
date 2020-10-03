package com.training.admissions.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdmissionRequestDTO {

    private Long facultyId;
    private Long userId;

}
