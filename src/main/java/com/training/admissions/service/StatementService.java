package com.training.admissions.service;

import com.training.admissions.entity.AdmissionRequest;
import com.training.admissions.entity.AdmissionRequestStatus;
import com.training.admissions.entity.Faculty;
import com.training.admissions.entity.StatementElement;
import com.training.admissions.exception.StatementCreationException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatementService {

    private static final String FILE_NAME = "src/main/resources/JasperDesign.jrxml";
    private static final String OUT_FILE = "src/main/resources/public/Reports.pdf";

    private final FacultyService facultyService;


    public StatementService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    public List<AdmissionRequest> getStatementForFacultyWithId(Long id) {
        Faculty faculty = facultyService.getById(id);

        return faculty.getAdmissionRequestList()
                .stream()
                .filter(x -> x.getStatus() == AdmissionRequestStatus.APPROVED)
                .sorted(
                        Comparator.comparingInt(AdmissionRequest::getSumOfGrades).reversed()
                                .thenComparing(AdmissionRequest::getCreationDateTime))
                .limit(faculty.getTotalCapacity())
                .collect(Collectors.toList());

    }

    public void facultyStatementFinalize(Long id, String author) {

        List<StatementElement> statementElementList = new ArrayList<>();
        for (AdmissionRequest ar : getStatementForFacultyWithId(id)) {

            statementElementList.add(StatementElement.builder()
                    .firstName(ar.getCandidate().getCandidateProfile().getFirstName())
                    .lastName(ar.getCandidate().getCandidateProfile().getLastName())
                    .grade(ar.getSumOfGrades())
                    .build());
        }

        try {
            createPdfReport(statementElementList, author);

        } catch (FileNotFoundException | JRException e) {
            throw new StatementCreationException("Can not create statement report");
        }

    }


    private void createPdfReport(final List<StatementElement> statementElementList, String author) throws JRException, FileNotFoundException {


        File templateFile = ResourceUtils.getFile(FILE_NAME);
        JasperReport jasperReport = JasperCompileManager.compileReport(templateFile.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(statementElementList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("author", "admin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        File file = new File(OUT_FILE);
        OutputStream outputSteam = new FileOutputStream(file);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputSteam);

    }

}
