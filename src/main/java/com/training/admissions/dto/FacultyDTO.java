package com.training.admissions.dto;


import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import lombok.*;

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
    private String description;
    private int budgetCapacity;
    private int totalCapacity;
    private String requiredSubject1;
    private String requiredSubject2;
    private String requiredSubject3;


    private List<AdmissionRequest>  admissionRequestsList;



    public int numberOfRequests(){
        return admissionRequestsList.size();
    }


    public Long numberOfRequestsNew(){
        return admissionRequestsList.stream()
                .filter(ar->ar.getStatus().ordinal()== AdmissionRequestStatus.NEW.ordinal())
                .count();
    }
    public Long numberOfRequestsApproved(){
        return admissionRequestsList.stream()
                .filter(ar->ar.getStatus().ordinal()== AdmissionRequestStatus.APPROVED.ordinal())
                .count();
    }
    public Long numberOfRequestsRejected(){
        return admissionRequestsList.stream()
                .filter(ar->ar.getStatus().ordinal()== AdmissionRequestStatus.REJECTED.ordinal())
                .count();
    }
}

