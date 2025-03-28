package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.dto.SecurityReportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import com.spring.parcialelitewingsapimiguelmemiliog.models.SecurityReport;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IFlightsRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ISecurityReportRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SecurityReportService implements ISecurityReportService {

    @Autowired
    private IFlightsRepository flightsRepository;

    @Autowired
    private ISecurityReportRepository securityReportRepository;

    private SecurityReportDTO EntityToDTO(SecurityReport securityReport) {
        return SecurityReportDTO.builder()
                .setId(securityReport.getId())
                .setReportedBy(securityReport.getReportedBy())
                .setDescription(securityReport.getDescription())
                .setResolved(securityReport.isResolved())
                .setFlight_Id(securityReport.getFlight().getId())
                .build();
    }

    private SecurityReport DTOtoEntity(SecurityReportDTO securityReportDTO) {

        Flights flight = flightsRepository.findById(securityReportDTO.getFlight_Id()).get();

        return SecurityReport.builder()
                .setId(securityReportDTO.getId())
                .setReportedBy(securityReportDTO.getReportedBy())
                .setDescription(securityReportDTO.getDescription())
                .setResolved(securityReportDTO.isResolved())
                .setFlight(flight)
                .build();
    }

    @Override
    public SecurityReportDTO registerReport(@Valid SecurityReportDTO securityreportDTO) {
        SecurityReport securityReport = DTOtoEntity(securityreportDTO);
        SecurityReport savedReport= securityReportRepository.save(securityReport);
        return EntityToDTO(savedReport);
    }

    @Override
    public List<SecurityReportDTO> getUnresolvedReports() {
        List<SecurityReportDTO> unresolvedReports = securityReportRepository.findSecurityReportByIsResolved(false).stream().map(this::EntityToDTO).toList();
        return unresolvedReports;
    }

    @Override
    public SecurityReportDTO resolveReport(Long id) {
        Optional<SecurityReport> securityReport = securityReportRepository.findById(id);
        if (securityReport.isPresent() && !securityReport.get().isResolved()) {
            securityReport.get().setResolved(true);
            securityReportRepository.save(securityReport.get());
            return EntityToDTO(securityReport.get());
        } else{
            return null;
        }
    }
}
