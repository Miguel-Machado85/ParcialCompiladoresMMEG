package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightsDTO {
    private Long id;

    @NotBlank(message = "The departure airport must be listed.")
    private String departureAirport;

    @NotBlank(message = "The arrival airport must be listed.")
    private String arrivalAirport;

    @NotBlank(message = "The flight must have a departure time.")
    private String departureTime;

    @NotBlank(message = "The flight must have an arrival time.")
    private String arrivalTime;

    private Long celebrity_Id;

    private Long jet_Id;

    @NotBlank(message = "Valid purpose required")
    private Flights.Purpose purpose;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getCelebrity_Id() {
        return celebrity_Id;
    }

    public void setCelebrity_Id(Long celebrity_Id) {
        this.celebrity_Id = celebrity_Id;
    }

    public Long getJet_Id() {
        return jet_Id;
    }

    public void setJet_Id(Long jet_Id) {
        this.jet_Id = jet_Id;
    }

    public Flights.Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Flights.Purpose purpose) {
        this.purpose = purpose;
    }
}
