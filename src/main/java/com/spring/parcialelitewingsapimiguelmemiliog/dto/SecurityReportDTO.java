package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

    private Long jet_Id;
}
