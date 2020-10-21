package com.training.admissions.dto;


import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class FacultyDTO {

    private Long id;
    @NotBlank(message = "fill the name on English")
    @Length(max = 50, message = "name is too long")
    private String nameEn;
    @NotBlank(message = "fill the name on Ukrainian")
    @Length(max = 50, message = "name is too long")
    private String nameUk;

    @NotBlank(message = "fill the description on English")
    @Length(max = 2048, message = "description is too long")
    private String descriptionEn;
    @NotBlank(message = "fill the description on Ukrainian")
    @Length(max = 2048, message = "description is too long")
    private String descriptionUk;
    @NotNull(message = "Capacity can not be empty")
    @Min(value = 0,message = "Capacity can not be less than 0")
    @Max(value = 999,message = "Capacity can not be more than 999")
    private Integer budgetCapacity;

    @NotNull(message = "Capacity can not be empty")
    @Min(value = 0,message = "Capacity can not be less than 0")
    @Max(value = 999,message = "Capacity can not be more than 999")
    private Integer totalCapacity;

    @NotBlank(message = "fill the subject on English")
    @Length(max = 50, message = "subject name is too long")
    private String requiredSubject1En;
    @NotBlank(message = "fill the subject on Ukrainian")
    @Length(max = 50, message = "subject name is too long")
    private String requiredSubject1Uk;
    @NotBlank(message = "fill the subject on English")
    @Length(max = 50, message = "subject name is too long")
    private String requiredSubject2En;
    @NotBlank(message = "fill the subject on Ukrainian")
    @Length(max = 50, message = "subject name is too long")
    private String requiredSubject2Uk;
    @NotBlank(message = "fill the subject on English")
    @Length(max = 50, message = "subject name is too long")
    private String requiredSubject3En;
    @NotBlank(message = "fill the subject on Ukrainian")
    @Length(max = 50, message = "subject name is too long")
    private String requiredSubject3Uk;

    private boolean admissionOpen;

    @AssertTrue(message = "budget capacity must be less or equals to total capacity")
    private boolean isValid() {
        if (this.budgetCapacity != null && this.totalCapacity != null) {
            return this.budgetCapacity <= this.totalCapacity;
        }
        return false;
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

