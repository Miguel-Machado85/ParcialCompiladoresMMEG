package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.PrivateJetDTO;

import java.util.Optional;

public interface IPrivateJetService {
    public PrivateJetDTO addPrivateJet(PrivateJetDTO privateJetDTO);
    public Optional<PrivateJetDTO> getPrivateJetById(Long id);
    public Optional<PrivateJetDTO> updatePrivateJet(Long id, PrivateJetDTO privateJetDTO);
    public void deletePrivateJet(Long id);
}
