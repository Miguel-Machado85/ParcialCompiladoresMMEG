package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.dto.SecurityReportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import com.spring.parcialelitewingsapimiguelmemiliog.models.SecurityReport;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IFlightsRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ISecurityReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityReportService implements ISecurityReportService {

    private IFlightsRepository flightsRepository;

    @Autowired
    private ISecurityReportRepository securityReportRepository;

    private SecurityReportDTO EntityToDTO(SecurityReport securityReport) {
        return SecurityReportDTO.builder()
                .id(securityReport.getId())
                .reportedBy(securityReport.getReportedBy())
                .description(securityReport.getDescription())
                .isResolved(securityReport.isResolved())
                .flight_Id(securityReport.getFlight().getId())
                .build();
    }

    private SecurityReport DTOtoEntity(SecurityReportDTO securityReportDTO) {

        Flights flight = flightsRepository.findById(securityReportDTO.getFlight_Id()).get();

        return SecurityReport.builder()
                .id(securityReportDTO.getId())
                .reportedBy(securityReportDTO.getReportedBy())
                .description(securityReportDTO.getDescription())
                .isResolved(securityReportDTO.isResolved())
                .flight(flight)
                .build();
    }

    @Override
    public SecurityReportDTO registerReport(SecurityReportDTO securityreportDTO) {
        SecurityReport securityReport = DTOtoEntity(securityreportDTO);
        SecurityReport savedReport= securityReportRepository.save(securityReport);
        return EntityToDTO(savedReport);
    }

    @Override
    public List<SecurityReportDTO> getUnresolvedReports() {
        List<SecurityReportDTO> unresolvedReports = securityReportRepository.findSecurityReportByResolved(false).stream().map(this::EntityToDTO).toList();
        return unresolvedReports;
    }

    @Override
    public void resolveReport(Long id) {

    }
}
