package com.training.admissions.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrolled_candidate")
public class EnrolledCandidate {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @NotBlank(message = "fill the email")
        @Email( message = "email is not correct")
        @Column(name = "email")
        private String email;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "grade")
        private Integer grade;

        @ManyToOne(targetEntity = Faculty.class, fetch = FetchType.EAGER)
        @JoinColumn(name = "statement_id")
        private Statement statement;





    }
