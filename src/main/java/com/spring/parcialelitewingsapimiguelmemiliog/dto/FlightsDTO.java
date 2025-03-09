package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightsDTO {
    private String id;

    @NotBlank(message = "The departure airport must be listed.")
    private String departureAirport;

    @NotBlank(message = "The arrival airport must be listed.")
    private String arrivalAirport;

    @NotBlank(message = "The flight must have a departure time.")
    private String departureTime;

    @NotBlank(message = "The flight must have an arrival time.")
    private String arrivalTime;

    private String celebrity_Id;

    private String jet_Id;
}
