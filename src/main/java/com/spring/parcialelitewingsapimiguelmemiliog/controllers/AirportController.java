package com.spring.parcialelitewingsapimiguelmemiliog.controllers;

import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;
import com.spring.parcialelitewingsapimiguelmemiliog.services.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AirportController {
    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping(path = "/airport/{id}")
    public ResponseEntity<airport> getAirport(@PathVariable String id){
        Optional<airport> aeropuertoEncontrado= airportService.encontrarPorId(id);
        return aeropuertoEncontrado.map(airport -> new ResponseEntity<airport>(airport, HttpStatus.OK))
                .orElse(new ResponseEntity<airport>(HttpStatus.NOT_FOUND));
    }
}
