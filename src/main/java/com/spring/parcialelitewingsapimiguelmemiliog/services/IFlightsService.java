package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IFlightsService {
    FlightsDTO registerFlight(@Valid FlightsDTO flightsDTO);
    Optional<FlightsDTO> flightById(Long id);
    void deleteFlightById(Long id);
    List<FlightsDTO> retrieveFlaggedFlights();
}
