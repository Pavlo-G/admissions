package com.training.admissions.dto;


import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacultyDTO {

    private Long id;

    private String nameEn;
    private String nameUk;

    @NotBlank(message = "fill the description on English")
    @Length(max = 2048, message = "description is too long")
    private String descriptionEn;
    @NotBlank(message = "fill the description on Ukrainian")
    @Length(max = 2048, message = "description is too long")
    private String descriptionUk;
    @Min(value = 1, message = "must be equal or greater than 1")
    @Max(value = 300, message = "must be equal or less than 300")
    private int budgetCapacity;
    @Min(value = 1, message = "must be equal or greater than 1")
    @Max(value = 300, message = "must be equal or less than 300")
    private int totalCapacity;

    private String requiredSubject1En;
    private String requiredSubject1Uk;
    private String requiredSubject2En;
    private String requiredSubject2Uk;
    private String requiredSubject3En;
    private String requiredSubject3Uk;

    private boolean admissionOpen;

    @AssertTrue(message = "budget capacity must be less or equals to total capacity")
    private boolean isValid() {
        return this.budgetCapacity <= this.totalCapacity;
    }

    private List<AdmissionRequest> admissionRequestsList;


    public Long numberOfRequestsNew() {
        return admissionRequestsList.stream()
                .filter(ar -> ar.getAdmissionRequestStatus().ordinal() == AdmissionRequestStatus.NEW.ordinal())
                .count();
    }

    public Long numberOfRequestsApproved() {
        return admissionRequestsList.stream()
                .filter(ar -> ar.getAdmissionRequestStatus().ordinal() == AdmissionRequestStatus.APPROVED.ordinal())
                .count();
    }

    public Long numberOfRequestsRejected() {
        return admissionRequestsList.stream()
                .filter(ar -> ar.getAdmissionRequestStatus().ordinal() == AdmissionRequestStatus.REJECTED.ordinal())
                .count();
    }
}

