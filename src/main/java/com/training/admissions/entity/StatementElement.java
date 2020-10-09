package com.training.admissions.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class StatementElement {
    private String facultyName;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private int grade;
    private String status;
}
