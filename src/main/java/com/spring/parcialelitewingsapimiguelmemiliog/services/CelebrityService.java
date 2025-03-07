package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.CelebrityDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ICelebrityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class CelebrityService implements ICelebrityService{

    @Autowired
    private ICelebrityRepository celebrityRepository;

    private CelebrityDTO convertToDTO(Celebrity celebrity) {
        return new CelebrityDTO(celebrity.getId(),
                celebrity.getName(),
                celebrity.getProfession(),
                celebrity.getNet_worth(),
                celebrity.isSuspicious_activity(),
                celebrity.getJets());
    }

    @Override
    public CelebrityDTO addCelebrity(@Valid CelebrityDTO celebrityDTO) {
        Celebrity celebrity = new Celebrity();
        celebrity.setId(celebrityDTO.getId());
        celebrity.setName(celebrityDTO.getName());
        celebrity.setProfession(celebrityDTO.getProfession());
        celebrity.setNet_worth(celebrityDTO.getNet_worth());
        celebrity.setSuspicious_activity(celebrityDTO.isSuspicious_activity());
        celebrity.setJets(celebrityDTO.getJets());

        celebrity = celebrityRepository.save(celebrity);

        return convertToDTO(celebrity);

    }

    @Override
    public Optional<CelebrityDTO> getCelebrity(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CelebrityDTO> updateCelebrity(Long id, CelebrityDTO celebrity) {
        return Optional.empty();
    }

    @Override
    public void deleteCelebrity(Long id) {

    }
}
