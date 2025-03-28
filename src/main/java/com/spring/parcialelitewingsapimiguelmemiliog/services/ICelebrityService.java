package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.CelebrityDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import jakarta.validation.Valid;

import java.util.Optional;

public interface ICelebrityService {
    public CelebrityDTO addCelebrity(@Valid CelebrityDTO celebrity);
    public Optional<CelebrityDTO> getCelebrity(Long id);
    public Optional<CelebrityDTO> updateCelebrity(Long id, @Valid CelebrityDTO celebrity);
    public void deleteCelebrity(Long id);
}
