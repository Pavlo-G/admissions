package com.training.admissions.service;

import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import com.training.admissions.entity.Faculty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatementService {

    private final FacultyService facultyService;


    public StatementService(FacultyService facultyService) {
        this.facultyService = facultyService;

    }


    public List<List<AdmissionRequest>> getStatement() {

        List<List<AdmissionRequest>> totalStatementList = new ArrayList<>();
        List<Faculty> facultyList = facultyService.getAllFaculties();

        for (Faculty f : facultyList) {

            List<AdmissionRequest> facultyStatementList = f.getAdmissionRequestList()
                    .stream()
                    .filter(x -> x.getStatus() == AdmissionRequestStatus.APPROVED)
                    .limit(f.getTotalCapacity())
                    .sorted(
                            Comparator.comparingInt(AdmissionRequest::getSumOfGrades).reversed()
                                    .thenComparing(AdmissionRequest::getCreationDateTime))
                    .collect(Collectors.toList());
            totalStatementList.add(List.copyOf(facultyStatementList));
            facultyStatementList.clear();
        }
        return totalStatementList;
    }
}
