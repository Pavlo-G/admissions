package com.training.admissions.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class StatementElement {

    private String firstName;
    private String lastName;
    private int grade;
}
