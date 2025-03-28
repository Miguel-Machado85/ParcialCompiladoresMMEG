package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.PrivateJetDTO;
import jakarta.validation.Valid;

import java.util.Optional;

public interface IPrivateJetService {
    public PrivateJetDTO addPrivateJet(@Valid PrivateJetDTO privateJetDTO);
    public Optional<PrivateJetDTO> getPrivateJetById(Long id);
    public Optional<PrivateJetDTO> updatePrivateJet(Long id, @Valid PrivateJetDTO privateJetDTO);
    public void deletePrivateJet(Long id);
}
