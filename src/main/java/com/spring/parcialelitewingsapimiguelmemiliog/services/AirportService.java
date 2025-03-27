package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.AirportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService {

    @Autowired
    private IAirportRepository airportRepository;

    private AirportDTO EntitytoDTO(airport airport) {
        return AirportDTO.builder()
                .setId(airport.getId())
                .setNombre(airport.getNombre())
                .setDireccion(airport.getDireccion())
                .setCapacidad(airport.getCapacidad())
                .setDueños(airport.getDueños()).build();
    }

    @Override
    public Optional<AirportDTO> encontrarPorId(Long id) {
        Optional<airport> aeropuertoEncontrado = airportRepository.findById(id);
        return aeropuertoEncontrado.map(this::EntitytoDTO);
    }

    @Override
    public List<AirportDTO> encontrarAeropuertos() {
        List<airport> aeropuertos= airportRepository.findAll();
        return aeropuertos.stream().map(this::EntitytoDTO).collect(Collectors.toList());
    }
}
