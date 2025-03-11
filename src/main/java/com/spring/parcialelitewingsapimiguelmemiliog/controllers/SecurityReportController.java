package com.spring.parcialelitewingsapimiguelmemiliog.controllers;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.SecurityReportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.SecurityReport;
import com.spring.parcialelitewingsapimiguelmemiliog.services.ISecurityReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecurityReportController {

    @Autowired
    private ISecurityReportService securityReportService;

    @PostMapping(path = "/security-reports")
    public ResponseEntity<SecurityReportDTO> addSecurityReport(@Valid @RequestBody SecurityReportDTO securityReport) {
        SecurityReportDTO savedReport= securityReportService.registerReport(securityReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReport);
    }

    @GetMapping(path = "/security-reports/unresolved")
    public ResponseEntity<List<SecurityReportDTO>> getUnresolvedReports() {
        List<SecurityReportDTO> unresolvedReports = securityReportService.getUnresolvedReports();
        return ResponseEntity.status(HttpStatus.OK).body(unresolvedReports);
    }
}
