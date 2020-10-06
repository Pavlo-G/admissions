package com.training.admissions.service;

import com.training.admissions.entity.*;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatementService {

    private final FacultyService facultyService;



    public StatementService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    public List<AdmissionRequest> getStatementForFacultyWithId(Long id) {
        Faculty faculty = facultyService.getById(id);

        return faculty.getAdmissionRequestList()
                .stream()
                .filter(x -> x.getStatus() == AdmissionRequestStatus.APPROVED)
                .limit(faculty.getTotalCapacity())
                .sorted(
                        Comparator.comparingInt(AdmissionRequest::getSumOfGrades).reversed()
                                .thenComparing(AdmissionRequest::getCreationDateTime))
                .collect(Collectors.toList());

    }

    public void facultyStatementFinalize(Long id, String author) {

        // send file to user

    }


}
