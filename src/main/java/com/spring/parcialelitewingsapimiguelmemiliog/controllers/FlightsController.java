package com.spring.parcialelitewingsapimiguelmemiliog.controllers;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.AirportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import com.spring.parcialelitewingsapimiguelmemiliog.services.FlightsService;
import com.spring.parcialelitewingsapimiguelmemiliog.services.IFlightsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightsController {

    @Autowired
    private IFlightsService flightsService;

    @PostMapping(path = "/flights")
    public ResponseEntity<FlightsDTO> addFlight(@Valid @RequestBody FlightsDTO flight) {
        FlightsDTO savedFlight= flightsService.registerFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @GetMapping(path = "/flights/{id}")
    public ResponseEntity<FlightsDTO> getFlight(@PathVariable long id) {
        Optional<FlightsDTO> flightFound= flightsService.flightById(id);
        return flightFound.map(flightsDTO -> new ResponseEntity<FlightsDTO>(flightsDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<FlightsDTO>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/flights/suspicious")
    public ResponseEntity<List<FlightsDTO>> getSuspiciousFlights() {
        List<FlightsDTO> flaggedFlights = flightsService.retrieveFlaggedFlights();
        return ResponseEntity.ok(flaggedFlights);
    }

    @DeleteMapping(path = "/flights/{id}")
    public ResponseEntity<FlightsDTO> deleteFlight(@PathVariable long id) {
        flightsService.deleteFlightById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
