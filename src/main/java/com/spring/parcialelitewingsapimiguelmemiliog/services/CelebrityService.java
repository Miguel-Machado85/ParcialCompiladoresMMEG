package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.CelebrityDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ICelebrityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class CelebrityService implements ICelebrityService{

    @Autowired
    private ICelebrityRepository celebrityRepository;

    private CelebrityDTO convertCelebToDTO(Celebrity celebrity) {
        return new CelebrityDTO(celebrity.getId(),
                celebrity.getName(),
                celebrity.getProfession(),
                celebrity.getNet_worth(),
                celebrity.isSuspicious_activity());
    }

    @Override
    public CelebrityDTO addCelebrity(@Valid CelebrityDTO celebrityDTO) {
        Celebrity celebrity = new Celebrity();
        celebrity.setId(celebrityDTO.getId());
        celebrity.setName(celebrityDTO.getName());
        celebrity.setProfession(celebrityDTO.getProfession());
        celebrity.setNet_worth(celebrityDTO.getNet_worth());
        celebrity.setSuspicious_activity(celebrityDTO.isSuspicious_activity());

        celebrity = celebrityRepository.save(celebrity);

        return convertCelebToDTO(celebrity);

    }

    @Override
    public Optional<CelebrityDTO> getCelebrity(Long id) {
        return celebrityRepository.findById(id).map(this::convertCelebToDTO);
    }

    @Override
    public Optional<CelebrityDTO> updateCelebrity(Long id,@Valid CelebrityDTO celebrity) {
        Optional<Celebrity> foundCeleb = celebrityRepository.findById(id);

        if(foundCeleb.isPresent()) {
            foundCeleb.get().setId(celebrity.getId());
            foundCeleb.get().setName(celebrity.getName());
            foundCeleb.get().setProfession(celebrity.getProfession());
            foundCeleb.get().setNet_worth(celebrity.getNet_worth());
            foundCeleb.get().setSuspicious_activity(celebrity.isSuspicious_activity());

            celebrityRepository.save(foundCeleb.get());
            return foundCeleb.map(this::convertCelebToDTO);
        } else{
            return Optional.empty();
        }
    }

    @Override
    public void deleteCelebrity(Long id) {
        celebrityRepository.deleteById(id);
    }
}
