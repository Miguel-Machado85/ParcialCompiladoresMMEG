package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;

import java.util.List;
import java.util.Optional;

public interface IFlightsService {
    FlightsDTO registerFlight(FlightsDTO flightsDTO);
    Optional<FlightsDTO> flightById(Long id);
    void deleteFlightById(Long id);
    List<FlightsDTO> retrieveFlaggedFlights();
}
