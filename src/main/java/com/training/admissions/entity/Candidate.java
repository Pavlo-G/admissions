package com.training.admissions.entity;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
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


    @Column(name = "username", unique = true)
    private String username;


    @Column(name = "password")
    private String password;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "candidate_status")
    private CandidateStatus candidateStatus;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "candidate")
    private CandidateProfile candidateProfile;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdmissionRequest> admissionRequestList;


    public Set<SimpleGrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority(role.name()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id) &&
                Objects.equals(username, candidate.username) &&
                Objects.equals(password, candidate.password) &&
                role == candidate.role &&
                candidateStatus == candidate.candidateStatus &&
                Objects.equals(candidateProfile, candidate.candidateProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, candidateStatus, candidateProfile);
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
