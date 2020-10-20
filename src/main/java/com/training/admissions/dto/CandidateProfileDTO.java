package com.training.admissions.dto;


import com.training.admissions.controller.CandidateController;
import com.training.admissions.entity.Candidate;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidateProfileDTO {

    private Long id;
    @NotBlank(message = "fill the first name")
    @Length(max = 50, message = " first name is too long")
    private String firstName;
    @NotBlank(message = "fill the  last name on English")
    @Length(max = 50, message = "first name is too long")
    private String lastName;
    @NotBlank(message = "fill the  email")
    @Email(message="email is not valid")
    private String email;
    @NotBlank(message = "fill the  address")
    @Length(max = 100, message = "address is too long")
    private String address;
    @NotBlank(message = "fill the  city")
    @Length(max = 50, message = "city name is too long")
    private String city;
    @NotBlank(message = "fill the  region")
    @Length(max = 50, message = "region name is too long")
    private String region;
    @NotBlank(message = "fill the school")
    @Length(max = 100, message = "school name is too long")
    private String school;
    @NotBlank(message = "fill the phone number")
    @Pattern(regexp = "[0-9]+", message = "wrong Sort number")
    private String phoneNumber;

    private  Long candidateId;

}
