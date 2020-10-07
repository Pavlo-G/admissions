package com.training.admissions.service;

import com.training.admissions.entity.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
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

        List<StatementElement> statementElementList = new ArrayList<>();
        for (AdmissionRequest ar : getStatementForFacultyWithId(id)) {

            statementElementList.add(StatementElement.builder()
                    .firstName(ar.getCandidate().getCandidateProfile().getFirstName())
                    .lastName(ar.getCandidate().getCandidateProfile().getLastName())
                    .grade(ar.getSumOfGrades())
                    .build());
        }


        try {
            try {
                createPdfReport(statementElementList, author);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (JRException e) {
            e.printStackTrace();
        }
        // send file to user

    }

    // Method to create the pdf file using the employee list datasource.
    private void createPdfReport(final List<StatementElement> statementElementList, String author) throws JRException, FileNotFoundException {
        String fileName = "src/main/resources/JasperDesign.jrxml";
        String outFile = "src/main/resources/public/Reports.pdf";

        File templateFile = ResourceUtils.getFile(fileName);
        JasperReport jasperReport = JasperCompileManager.compileReport(templateFile.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(statementElementList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("author", "admin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        File file = new File(outFile);
        OutputStream outputSteam = new FileOutputStream(file);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputSteam);

    }

}
