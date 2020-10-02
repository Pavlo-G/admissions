package com.training.admissions.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacultyDTO {

    private Long id;
    private String name;
    private String description;
    private int budgetCapacity;
    private int totalCapacity;
}

