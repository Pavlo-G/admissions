package com.training.admissions.entity;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "candidate")
public class Candidate {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name = "username", unique=true)
    private String username;


    @Column(name = "password")
    private String password;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private CandidateStatus candidateStatus;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "candidate")
    private CandidateProfile candidateProfile;

    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private List<AdmissionRequest> admissionRequestList;


    public Set<SimpleGrantedAuthority> getAuthorities(){
        return Set.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", candidateStatus=" + candidateStatus +
                '}';
    }
}
