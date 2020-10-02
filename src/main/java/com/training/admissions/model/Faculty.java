package com.training.admissions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table( name="faculty",
        uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "budget_capacity", nullable = false)
    private int budgetCapacity;
    @Column(name = "total_capacity", nullable = false)
    private int totalCapacity;

}