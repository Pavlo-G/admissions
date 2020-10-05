package com.training.admissions.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table( name="admission_request")
@Entity
public class AdmissionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long  id;
    @Column(name = "status", nullable = false)
    private AdmissionRequestStatus status;

    @ManyToOne(targetEntity = Candidate.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    private Candidate candidate;

    @ManyToOne(targetEntity = Faculty.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "faculty", referencedColumnName = "id")
    private Faculty faculty;

    @CreationTimestamp
    @Column(name = "creation_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDateTime;




}
