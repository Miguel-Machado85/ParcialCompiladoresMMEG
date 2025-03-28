package com.spring.parcialelitewingsapimiguelmemiliog.repositories;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightsRepository extends JpaRepository<Flights, Long> {
    public List<Flights> findFlightsByPurpose(Flights.Purpose purpose);
}
