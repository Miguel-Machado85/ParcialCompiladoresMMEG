package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.AirportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;
import java.util.List;

import java.util.Optional;

public interface IAirportService {
    Optional<AirportDTO> encontrarPorId(String id);
    List<airport> encontrarAeropuertos();
}
