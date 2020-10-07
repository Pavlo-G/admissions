package com.training.admissions.report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

import java.io.InputStream;

public class JasperCompilerManager {

    InputStream employeeReportStream
            = getClass().getResourceAsStream("/report.jrxml");
    JasperReport jasperReport
            = JasperCompileManager.compileReport(employeeReportStream);

    public JasperCompilerManager() throws JRException {
    }
}
