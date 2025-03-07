package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IAirportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService implements IAirportService {
    private IAirportRepository airportRepository;

    @Override
    public Optional<airport> encontrarPorId(String id) {
        return airportRepository.findById(id);
    }
}
