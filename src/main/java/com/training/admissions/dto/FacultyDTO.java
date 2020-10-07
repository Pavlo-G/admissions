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

    private String name;
    @NotBlank(message = "fill the description")
    @Length(max = 2048, message = "description is too long")
    private String description;
    @Min(value = 1, message = "must be equal or greater than 1")
    @Max(value = 300, message = "must be equal or less than 300")
    private int budgetCapacity;
    @Min(value = 1, message = "must be equal or greater than 1")
    @Max(value = 300, message = "must be equal or less than 300")
    private int totalCapacity;

    private String requiredSubject1;
    private String requiredSubject2;
    private String requiredSubject3;

    private boolean admissionOpen;

    @AssertTrue(message = "budget capacity must be less or equals to total capacity")
    private boolean isValid() {
        return this.budgetCapacity <= this.totalCapacity;
    }

    private List<AdmissionRequest> admissionRequestsList;


    public Long numberOfRequestsNew() {
        return admissionRequestsList.stream()
                .filter(ar -> ar.getStatus().ordinal() == AdmissionRequestStatus.NEW.ordinal())
                .count();
    }

    public Long numberOfRequestsApproved() {
        return admissionRequestsList.stream()
                .filter(ar -> ar.getStatus().ordinal() == AdmissionRequestStatus.APPROVED.ordinal())
                .count();
    }

    public Long numberOfRequestsRejected() {
        return admissionRequestsList.stream()
                .filter(ar -> ar.getStatus().ordinal() == AdmissionRequestStatus.REJECTED.ordinal())
                .count();
    }
}

