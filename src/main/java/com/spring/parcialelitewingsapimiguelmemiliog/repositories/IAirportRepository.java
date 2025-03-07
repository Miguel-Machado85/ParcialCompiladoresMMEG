package com.spring.parcialelitewingsapimiguelmemiliog.repositories;

import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportRepository extends JpaRepository<airport, String> {

}
