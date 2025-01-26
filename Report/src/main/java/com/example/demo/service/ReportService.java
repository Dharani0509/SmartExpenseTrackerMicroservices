package com.example.demo.service;

import com.example.demo.entity.Report;
import java.util.List;

public interface ReportService {

    Report saveReport(Report report);

    List<Report> getAllReports();

    Report getReportById(Long reportId);

    void deleteReport(Long reportId);
}
