package com.spring.parcialelitewingsapimiguelmemiliog.repositories;

import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICelebrityRepository extends JpaRepository<Celebrity, Long> {
}
