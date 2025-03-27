package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityReportDTO {
    private Long id;

    @NotBlank(message = "The report needs to be done by someone.")
    private String reportedBy;

    @NotBlank(message = "There needs to be a description")
    private String description;

    private boolean isResolved= false;

    private Long flight_Id;

    public SecurityReportDTO() {
    }

    public static SecurityReportDTO builder(){
        return new SecurityReportDTO();
    }

    public SecurityReportDTO build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public SecurityReportDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public SecurityReportDTO setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SecurityReportDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public SecurityReportDTO setResolved(boolean resolved) {
        isResolved = resolved;
        return this;
    }

    public Long getFlight_Id() {
        return flight_Id;
    }

    public SecurityReportDTO setFlight_Id(Long flight_Id) {
        this.flight_Id = flight_Id;
        return this;
    }
}
