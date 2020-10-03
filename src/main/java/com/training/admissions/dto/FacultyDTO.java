package com.training.admissions.dto;


import com.training.admissions.model.AdmissionRequest;
import com.training.admissions.model.Faculty;
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

    private List<AdmissionRequest>  admissionRequestsList;



    public int numberOfRequests(){
        return admissionRequestsList.size();
    }


}

