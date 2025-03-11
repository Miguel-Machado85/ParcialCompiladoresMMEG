package com.spring.parcialelitewingsapimiguelmemiliog.services;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.AirportDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.dto.CelebrityDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.dto.FlightsDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Celebrity;
import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import com.spring.parcialelitewingsapimiguelmemiliog.models.airport;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.ICelebrityRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IFlightsRepository;
import com.spring.parcialelitewingsapimiguelmemiliog.repositories.IPrivateJetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FlightsService implements IFlightsService {

    @Autowired
    private IFlightsRepository flightsRepository;

    @Autowired
    private ICelebrityRepository celebrityRepository;

    @Autowired
    private IPrivateJetRepository privateJetRepository;

    private FlightsDTO EntityToDTO(Flights flights) {
        return FlightsDTO.builder()
                .id(flights.getId())
                .departureAirport(flights.getDepartureAirport())
                .arrivalAirport(flights.getArrivalAirport())
                .departureTime(flights.getDepartureTime())
                .arrivalTime(flights.getArrivalTime())
                .celebrity_Id(flights.getCelebrity().getId())
                .jet_Id(flights.getPrivateJet().getId())
                .purpose(flights.getPurpose()).build();
    }

    private Flights DTOtoEntity(FlightsDTO flightsDTO) {
        Celebrity celebrity= celebrityRepository.findById(flightsDTO.getCelebrity_Id()).get();

        PrivateJet privateJet = privateJetRepository.findById(flightsDTO.getJet_Id()).get();

        return Flights.builder()
                .id(flightsDTO.getId())
                .departureAirport(flightsDTO.getDepartureAirport())
                .arrivalAirport(flightsDTO.getArrivalAirport())
                .departureTime(flightsDTO.getDepartureTime())
                .arrivalTime(flightsDTO.getArrivalTime())
                .celebrity(celebrity)
                .privateJet(privateJet)
                .purpose(flightsDTO.getPurpose())
                .build();
    }

    @Override
    public FlightsDTO registerFlight(FlightsDTO flightsDTO) {
        Flights flights = DTOtoEntity(flightsDTO);
        Flights savedFlights = flightsRepository.save(flights);
        return EntityToDTO(savedFlights);
    }

    @Override
    public Optional<FlightsDTO> flightById(Long id) {
        Optional<Flights> flightFound = flightsRepository.findById(id);
        return flightFound.map(this::EntityToDTO);
    }

    @Override
    public void deleteFlightById(Long id) {
        try {
            flightsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.debug("Can't delete non existing flight", e);
        }
    }

    @Override
    public List<FlightsDTO> retrieveFlaggedFlights() {
        List<FlightsDTO> flaggedFlights= flightsRepository.findFlightsByPurpose("Suspicious").stream().map(this::EntityToDTO).collect(Collectors.toList());
        return flaggedFlights;
    }
}
