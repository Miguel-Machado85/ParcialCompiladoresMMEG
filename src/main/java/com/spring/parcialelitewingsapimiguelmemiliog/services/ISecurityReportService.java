package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.SecurityReportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.SecurityReport;
import jakarta.validation.Valid;

import java.util.List;

public interface ISecurityReportService {
    SecurityReportDTO registerReport(@Valid SecurityReportDTO securityreportDTO);
    List<SecurityReportDTO> getUnresolvedReports();
    SecurityReportDTO resolveReport(Long id);
}
