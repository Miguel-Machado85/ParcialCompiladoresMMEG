package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.SecurityReportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.SecurityReport;
import java.util.List;

public interface ISecurityReportService {
    SecurityReportDTO registerReport(SecurityReportDTO securityreportDTO);
    List<SecurityReportDTO> getUnresolvedReports();
    void resolveReport(Long id);
}
