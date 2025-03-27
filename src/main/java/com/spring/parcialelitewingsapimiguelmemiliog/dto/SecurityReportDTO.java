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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    public Long getFlight_Id() {
        return flight_Id;
    }

    public void setFlight_Id(Long flight_Id) {
        this.flight_Id = flight_Id;
    }
}
