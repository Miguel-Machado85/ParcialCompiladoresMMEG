package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;

import java.util.Optional;

public interface IAirportService {
    Optional<airport> encontrarPorId(String id);
}
