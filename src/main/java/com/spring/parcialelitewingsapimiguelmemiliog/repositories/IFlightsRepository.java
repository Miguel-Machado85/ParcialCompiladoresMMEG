package com.spring.parcialelitewingsapimiguelmemiliog.repositories;

import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightsRepository extends JpaRepository<Flights, String> {
}
