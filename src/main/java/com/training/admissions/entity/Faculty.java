package com.training.admissions.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "admission_open", nullable = false)
    private boolean admissionOpen;

    @OneToMany(mappedBy = "faculty",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private List<AdmissionRequest> admissionRequestList;


    public Long numberOfRequestsNew() {
        return admissionRequestList.stream()
                .filter(ar -> ar.getStatus().ordinal() == AdmissionRequestStatus.NEW.ordinal())
                .count();
    }

    public Long numberOfRequestsApproved() {
        return admissionRequestList.stream()
                .filter(ar -> ar.getStatus().ordinal() == AdmissionRequestStatus.APPROVED.ordinal())
                .count();
    }

    public Long numberOfRequestsRejected() {
        return admissionRequestList.stream()
                .filter(ar -> ar.getStatus().ordinal() == AdmissionRequestStatus.REJECTED.ordinal())
                .count();
    }



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