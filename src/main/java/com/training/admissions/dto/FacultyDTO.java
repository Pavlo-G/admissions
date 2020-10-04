package com.training.admissions.dto;


import com.training.admissions.model.AdmissionRequest;
import com.training.admissions.model.AdmissionRequestStatus;
import com.training.admissions.model.Faculty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

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

