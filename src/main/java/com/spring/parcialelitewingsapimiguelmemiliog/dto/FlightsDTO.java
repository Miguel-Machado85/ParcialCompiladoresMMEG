package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
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

    @NotNull(message = "Valid purpose required")
    private Flights.Purpose purpose;

    public FlightsDTO() {
    }

    public static FlightsDTO builder(){
        return new FlightsDTO();
    }

    public FlightsDTO build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public FlightsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public FlightsDTO setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
        return this;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public FlightsDTO setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        return this;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public FlightsDTO setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public FlightsDTO setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public Long getCelebrity_Id() {
        return celebrity_Id;
    }

    public FlightsDTO setCelebrity_Id(Long celebrity_Id) {
        this.celebrity_Id = celebrity_Id;
        return this;
    }

    public Long getJet_Id() {
        return jet_Id;
    }

    public FlightsDTO setJet_Id(Long jet_Id) {
        this.jet_Id = jet_Id;
        return this;
    }

    public Flights.Purpose getPurpose() {
        return purpose;
    }

    public FlightsDTO setPurpose(Flights.Purpose purpose) {
        this.purpose = purpose;
        return this;
    }
}
