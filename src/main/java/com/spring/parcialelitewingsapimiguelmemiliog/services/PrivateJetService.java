package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.PrivateJetDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IPrivateJetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class PrivateJetService implements IPrivateJetService{

    @Autowired
    private IPrivateJetRepository privateJetRepository;

    @Override
    public PrivateJetDTO addPrivateJet(PrivateJetDTO privateJetDTO) {
        return null;
    }

    @Override
    public Optional<PrivateJetDTO> getPrivateJetById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PrivateJetDTO> updatePrivateJet(Long id, PrivateJetDTO privateJetDTO) {
        return Optional.empty();
    }

    @Override
    public void deletePrivateJet(Long id) {

    }
}
