package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.PrivateJetDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ICelebrityRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IPrivateJetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class PrivateJetService implements IPrivateJetService{

    @Autowired
    private IPrivateJetRepository privateJetRepository;

    @Autowired
    private ICelebrityRepository celebrityRepository;

    public PrivateJetDTO convertJetToDTO(PrivateJet privateJet) {
        return new PrivateJetDTO(privateJet.getId(),
                privateJet.getModel(),
                privateJet.getCapacity(),
                privateJet.getOwner().getId());
    }

    @Override
    public PrivateJetDTO addPrivateJet(@Valid PrivateJetDTO privateJetDTO) {
        Celebrity owner = celebrityRepository.findById(privateJetDTO.getOwnerId()).get();

        PrivateJet privateJet = new PrivateJet();
        privateJet.setId(privateJetDTO.getId());
        privateJet.setModel(privateJetDTO.getModel());
        privateJet.setCapacity(privateJetDTO.getCapacity());
        privateJet.setOwner(owner);

        privateJet = privateJetRepository.save(privateJet);

        return convertJetToDTO(privateJet);
    }

    @Override
    public Optional<PrivateJetDTO> getPrivateJetById(Long id) {
        return privateJetRepository.findById(id).map(this::convertJetToDTO);
    }

    @Override
    public Optional<PrivateJetDTO> updatePrivateJet(Long id,@Valid PrivateJetDTO privateJetDTO) {
        Optional<PrivateJet> foundJet = privateJetRepository.findById(id);
        if (foundJet.isPresent()) {
            foundJet.get().setModel(privateJetDTO.getModel());
            foundJet.get().setCapacity(privateJetDTO.getCapacity());
            foundJet.get().setOwner(foundJet.get().getOwner());

            privateJetRepository.save(foundJet.get());
            return foundJet.map(this::convertJetToDTO);
        } else{
            return Optional.empty();
        }
    }

    @Override
    public void deletePrivateJet(Long id) {
        privateJetRepository.deleteById(id);
    }
}
