package com.spring.parcialelitewingsapimiguelmemiliog.controllers;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.AirportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;
import com.spring.parcialelitewingsapimiguelmemiliog.services.AirportService;
import com.spring.parcialelitewingsapimiguelmemiliog.services.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AirportController {
    @Autowired
    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping(path = "/airport/{id}")
    public ResponseEntity<AirportDTO> getAirport(@PathVariable String id){
        Optional<AirportDTO> aeropuertoEncontrado= airportService.encontrarPorId(id);
        return aeropuertoEncontrado.map(airportDTO -> new ResponseEntity<AirportDTO>(airportDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<AirportDTO>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/airport")
    public ResponseEntity<List<AirportDTO>> listAirport(){
        return new ResponseEntity<List<AirportDTO>>(airportService.encontrarAeropuertos(), HttpStatus.OK);
    }
}
