package com.training.admissions.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "description", length = 2048, nullable = false)
    private String description;
    @Column(name = "budget_capacity", nullable = false)
    private int budgetCapacity;
    @Column(name = "total_capacity", nullable = false)
    private int totalCapacity;

    @Column(name = "req_subject1", nullable = false)
    private String requiredSubject1;
    @Column(name = "req_subject2", nullable = false)
    private String requiredSubject2;
    @Column(name = "req_subject3", nullable = false)
    private String requiredSubject3;

    @OneToMany(mappedBy = "faculty",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private List<AdmissionRequest> admissionRequestList;

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", budgetCapacity=" + budgetCapacity +
                ", totalCapacity=" + totalCapacity +
                ", requiredSubject1='" + requiredSubject1 + '\'' +
                ", requiredSubject2='" + requiredSubject2 + '\'' +
                ", requiredSubject3='" + requiredSubject3 + '\'' +
                '}';
    }
}